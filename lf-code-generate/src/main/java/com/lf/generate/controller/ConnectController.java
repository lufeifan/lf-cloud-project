package com.lf.generate.controller;

import com.lf.common.core.utils.R;
import com.lf.generate.entity.DbInfo;
import com.lf.generate.entity.TableInfo;
import com.lf.generate.service.DbService;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/tableInfo")
    public R tableInfo(@RequestBody DbInfo dbInfo) throws SQLException {
        List<TableInfo> tableInfos = dbService.tableInfo(dbInfo);
        tableInfos.forEach(tableInfo -> {
            try {
                dbService.columninfo(dbInfo,tableInfo.getTableName()).forEach(System.out::println);
                System.out.println();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        });
        return R.setData(dbInfo);
    }
}
