package com.lf.generate.service.impl;

import com.lf.generate.entity.ColumnInfo;
import com.lf.generate.entity.DbInfo;
import com.lf.generate.entity.TableInfo;
import com.lf.generate.service.DbService;
import com.lf.generate.utils.DbUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 获取信息实现类
 *
 * @author lufeifan
 * @date 2021/10/25 18:53
 **/
@Service
public class DbServiceImpl implements DbService {

    @Override
    public List<TableInfo> tableInfo(DbInfo dbInfo) throws SQLException {
//      获取 Connection 对象
        Connection conn = DbUtils.getConnect(dbInfo);
        List<TableInfo> tableInfo = DbUtils.getTableInfo(conn);
        conn.close();
        return tableInfo;
    }

    @Override
    public List<ColumnInfo> columnInfo(DbInfo dbInfo, String tableName) throws SQLException, ConfigurationException {
        Connection conn = DbUtils.getConnect(dbInfo);
        List<ColumnInfo> infoList = DbUtils.getColumnInfo(conn, tableName);
        conn.close();
        return infoList;
    }

}
