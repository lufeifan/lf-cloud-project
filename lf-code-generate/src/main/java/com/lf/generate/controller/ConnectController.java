package com.lf.generate.controller;

import com.lf.common.core.utils.R;
import com.lf.generate.entity.ColumnInfo;
import com.lf.generate.entity.DbInfo;
import com.lf.generate.entity.TableInfo;
import com.lf.generate.service.DbService;
import com.lf.generate.service.GenerateConfigService;
import com.lf.generate.vo.BaseInfoVo;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * 获取数据库信息
 *
 * @author lufeifan
 * @date 2021/10/25 18:43
 **/
@RestController
public class ConnectController {

    @Autowired
    private DbService dbService;

    @Autowired
    private GenerateConfigService generateConfigService;

    @PostMapping("/tableInfo")
    public R tableInfo(@RequestBody BaseInfoVo baseInfoVo) throws SQLException, ConfigurationException {
        DbInfo dbInfo = baseInfoVo.getDbInfo();
//        获取全部表信息
        List<TableInfo> tableInfos = dbService.tableInfo(dbInfo);
        for (TableInfo tableInfo : tableInfos) {
//          默认类名生成
            generateConfigService.classGenerateConfig(tableInfo);
//            获取列信息
            List<ColumnInfo> columnInfos = dbService.columnInfo(dbInfo, tableInfo.getTableName());
            tableInfo.setColumnInfos(columnInfos);
        }
        return R.setData(tableInfos);
    }

    @PostMapping("/columnInfo/{tableName}")
    public R columnInfo(@RequestBody DbInfo dbInfo, @PathVariable String tableName) throws SQLException, ConfigurationException {
        List<ColumnInfo> columnInfos = dbService.columnInfo(dbInfo,tableName);
        return R.setData(columnInfos);
    }
}
