package com.lf.generate.controller;

import com.lf.common.core.utils.R;
import com.lf.generate.entity.*;
import com.lf.generate.service.DbService;
import com.lf.generate.service.GenerateConfigService;
import com.lf.generate.utils.TemplateUtils;
import freemarker.template.TemplateException;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

    @Autowired
    private DbService dbService;

    /**
     * 前端展示数据库信息，用户可以根据信息进行配置（表前缀是否要去除，注释，是否自动填充，是否逻辑删除
     * 用户点击配置按钮，课展示配置生成信息详情，和生成数据预览效果。
     */
    @PostMapping("/generateConfig")
    public R generateConfig(@RequestBody GenerateInfo info) throws SQLException, ConfigurationException {
        GenerateInfo generateInfo = generateConfigService.generateConfig(info);
        List<TableInfo> tableInfoList = generateInfo.getTableInfo();
        for (TableInfo tableInfo : tableInfoList) {
            String tableName = tableInfo.getTableName();
            List<ColumnInfo> columnInfos = dbService.columnInfo(generateInfo.getDbInfo(), tableName);
            tableInfo.setColumnInfos(columnInfos);
        }
        return R.setData(generateInfo);
    }

    /**
     *
     * @param configInfo 生成的数据
     * @return
     */
    @PostMapping("/generateCode")
    public void generateCode(@RequestBody ConfigInfo configInfo,HttpServletResponse response) throws IOException, TemplateException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TemplateUtils.fillTemplate(configInfo, outputStream);
        byte[] data = outputStream.toByteArray();
        response.setHeader("Content-Disposition", "attachment; filename=lf_code_generator.zip");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream;application/zip; charset=UTF-8");
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
    }
}
