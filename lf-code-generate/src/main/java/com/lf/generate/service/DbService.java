package com.lf.generate.service;

import com.lf.generate.entity.ColumnInfo;
import com.lf.generate.entity.DbInfo;
import com.lf.generate.entity.TableInfo;
import org.apache.commons.configuration.ConfigurationException;

import java.sql.SQLException;
import java.util.List;

/**
 * 表信息接口
 *
 * @author lufeifan
 * @date 2021/10/25 18:52
 **/
public interface DbService {
    /**
     * 获取表信息
     * @param dbInfo
     * @return
     */
    List<TableInfo> tableInfo(DbInfo dbInfo) throws SQLException;

    /**
     * 获取列信息
     * @param dbInfo
     * @param tableName
     * @return
     * @throws SQLException
     * @throws ConfigurationException
     */
    List<ColumnInfo> columninfo(DbInfo dbInfo,String tableName) throws SQLException, ConfigurationException;
}
