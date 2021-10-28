package com.lf.generate.controller;

import com.lf.common.core.utils.R;
import com.lf.generate.entity.*;
import com.lf.generate.service.DbService;
import com.lf.generate.service.GenerateConfigService;
import com.lf.generate.utils.TemplateUtils;
import com.lf.generate.vo.GenerateInfoVo;
import com.lf.generate.vo.PreviewInfoVo;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CommonsLogWriter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 生成
 *
 * @author lufeifan
 * @date 2021/10/25 19:35
 **/
@RestController
public class GenerateController {

    @Autowired
    private GenerateConfigService generateConfigService;

    /**
     * 前端展示数据库信息，用户可以根据信息进行配置（表前缀是否要去除，注释，是否自动填充，是否逻辑删除
     * 用户点击配置按钮，课展示配置生成信息详情，和生成数据预览效果。
     */
    @PostMapping("/generateConfig")
    public R generateConfig(@RequestBody List<TableInfo> tableInfoList) throws SQLException {
        for (TableInfo tableInfo : tableInfoList) {
//          配置类名
            generateConfigService.classGenerateConfig(tableInfo);
//          配置属性字段
            List<ColumnInfo> columnInfos = tableInfo.getColumnInfos();
            generateConfigService.fieldGenerateConfig(columnInfos);
        }
        return R.setData(tableInfoList);
    }

    /**
     * @param configInfo 生成的数据
     * @return
     */
    @PostMapping("/generateCode")
    public void generateCode(@RequestBody GenerateInfoVo configInfo, HttpServletResponse response) throws IOException, TemplateException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TemplateUtils.fillTemplate(configInfo, outputStream);
        byte[] data = outputStream.toByteArray();
        response.setHeader("Content-Disposition", "attachment; filename=lf_code_generator.zip");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream;application/zip; charset=UTF-8");
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.getOutputStream().write(data);

    }

    /**
     * @param type
     * @param previewInfoVo
     * @param response
     * @return
     * @Description:
     * @author lufeifan
     * @date 2021/10/28 19:37
     */
    @PostMapping("/preview/{type}")
    public void preview(@PathVariable String type, @RequestBody PreviewInfoVo previewInfoVo, HttpServletResponse response) throws IOException, TemplateException {

        TableInfo tableInfos = previewInfoVo.getTableInfos();
        Map<String, Object> mapData = TemplateUtils.getMapData(previewInfoVo.getPackInfo(), tableInfos);

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setTemplateLoader(new ClassTemplateLoader(GenerateController.class, "/templates"));
        cfg.setDefaultEncoding("UTF-8");
        Template template = null;
        if ("entity".equals(type)) {
            template = cfg.getTemplate("entity.java.ftl");
        }
        if ("mapper".equals(type)) {
            template = cfg.getTemplate("mapper.java.ftl");
        }
        if ("server".equals(type)) {
            template = cfg.getTemplate("service.java.ftl");
        }
        if ("Impl".equals(type)) {
            template = cfg.getTemplate("serviceImpl.java.ftl");
        }
        ServletOutputStream outputStream = response.getOutputStream();
        template.process(mapData, new OutputStreamWriter(outputStream));
    }
}
