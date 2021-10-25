package com.lf.generate.controller;

import com.lf.common.core.utils.R;
import com.lf.generate.entity.ColumnInfo;
import com.lf.generate.entity.DbInfo;
import com.lf.generate.entity.GenerateInfo;
import com.lf.generate.entity.TableInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 生成
 *
 * @author lufeifan
 * @date 2021/10/25 19:35
 **/
@RestController
public class GenerateController {

    /**
     * 前端展示数据库信息，用户可以根据信息进行配置（表前缀是否要去除，注释，是否自动填充，是否逻辑删除
     * 用户点击配置按钮，课展示配置生成信息详情，和生成数据预览效果。
     */
    @PostMapping("/generateConfig")
    public R generateConfig(@RequestBody GenerateInfo info){
        DbInfo dbInfo = info.getDbInfo();
        List<TableInfo> tableInfo = info.getTableInfo();
        List<ColumnInfo> columnInfos = info.getColumnInfos();

        return R.ok();
    }
}
