package com.lf.generate.entity;

import lombok.Data;

/**
 * 表信息
 *
 * @author lufeifan
 * @date 2021/10/25 18:26
 **/
@Data
public class TableInfo {

    /**
     *  表名
     **/
    private String tableName;
    /**
     *  表的注解
     **/
    private String tableRemarks;

    /**
     *  表的主键
     **/
    private String primaryKey;

    /**
     *  表名转化为java类名
     **/
    private String className;

    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 是否去除前缀
     */
    private Boolean isRemovePrefix;
}
