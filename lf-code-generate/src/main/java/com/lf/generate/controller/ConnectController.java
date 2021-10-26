package com.lf.generate.controller;

import com.lf.common.core.utils.R;
import com.lf.generate.entity.ColumnInfo;
import com.lf.generate.entity.DbInfo;
import com.lf.generate.entity.TableInfo;
import com.lf.generate.service.DbService;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/tableInfo")
    public R tableInfo(@RequestBody DbInfo dbInfo) throws SQLException {
        List<TableInfo> tableInfos = dbService.tableInfo(dbInfo);
        return R.setData(tableInfos);
    }

    @PostMapping("/columnInfo/{tableName}")
    public R columnInfo(@RequestBody DbInfo dbInfo, @PathVariable String tableName) throws SQLException, ConfigurationException {
        List<ColumnInfo> columnInfos = dbService.columnInfo(dbInfo,tableName);
        return R.setData(columnInfos);
    }
}
