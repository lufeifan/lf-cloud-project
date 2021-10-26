package com.lf.generate.entity;

import lombok.Data;

/**
 * 列信息
 *
 * @author lufeifan
 * @date 2021/10/25 18:27
 **/
@Data
public class ColumnInfo {
    /**
     *  列名
     **/
    private String columnName;
    /**
     *  列的类型
     **/
    private String columnType;
    /**
     *  列的注释
     **/
    private String columnRemarks;

    /**
     * 是否 自动插入填充
     */
    private Boolean isAutoInsertFill = false;

    /**
     * 是否 自动更新填充
     */
    private Boolean isAutoUpdateFile = false;

    /**
     * 转化为 java 类名
     */
    private String columnJavaName;

    /**
     * 转化为 java 类型
     */
    private String columnJavaType;

    /**
     * 是否是逻辑删除
     */
    private Boolean isLogicalDeletion = false;
}
