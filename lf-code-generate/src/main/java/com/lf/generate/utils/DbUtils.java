package com.lf.generate.utils;

import com.lf.generate.entity.ColumnInfo;
import com.lf.generate.entity.DbInfo;
import com.lf.generate.entity.TableInfo;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Db 工具类
 *
 * @author lufeifan
 * @date 2021/10/25 18:56
 **/
public class DbUtils {

    /**
     * 获取连接对象
     * @param dbInfo
     * @return
     * @throws SQLException
     */
    public static Connection getConnect(DbInfo dbInfo) throws SQLException {
        Connection conn = DriverManager.getConnection(
                dbInfo.getUrl(),
                dbInfo.getUsername(),
                dbInfo.getPassword()
        );
        return conn;
    }

    /**
     * 获取表信息
     * @param conn
     * @return
     * @throws SQLException
     */
    public static List<TableInfo> getTableInfo(Connection conn) throws SQLException {
        List<TableInfo> tableInfoList = new ArrayList<>();
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet tables = metaData.getTables(conn.getCatalog(), null, null, new String[]{"TABLE"});
        while (tables.next()) {
            TableInfo tableInfo = new TableInfo();

            String tableName = tables.getString("table_name");
            String remarks = tables.getString("REMARKS");

            tableInfo.setTableName(tableName);
            tableInfo.setTableRemarks(remarks);
//          获取主键
            ResultSet primaryKeys = metaData.getPrimaryKeys(conn.getCatalog(), null, tableName);
            while (primaryKeys.next()){
                String keysString = primaryKeys.getString("COLUMN_NAME");
                tableInfo.setPrimaryKey(keysString);
            }
            tableInfoList.add(tableInfo);
        }
        return tableInfoList;
    }

    public static List<ColumnInfo> getColumnInfo(Connection conn,String tableName) throws SQLException, ConfigurationException {
        List<ColumnInfo> list = new ArrayList<>();
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration("generator.properties");
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet columns = metaData.getColumns(conn.getCatalog(), null, tableName, null);
        while (columns.next()) {
            ColumnInfo columnInfo = new ColumnInfo();

            String column_name = columns.getString("COLUMN_NAME");
            columnInfo.setColumnName(column_name);
//          将JDBC 类型转化为 Java 类型
            String remarks = columns.getString("REMARKS");
            columnInfo.setColumnRemarks(remarks);

            String type_name = columns.getString("TYPE_NAME");
            columnInfo.setColumnType(type_name);

            String javaTypeName = propertiesConfiguration.getString(type_name.toLowerCase(), type_name);
            columnInfo.setColumnJavaName(javaTypeName);

            list.add(columnInfo);
        }
        return list;
    }
}
