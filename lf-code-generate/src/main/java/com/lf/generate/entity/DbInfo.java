package com.lf.generate.entity;

import lombok.Data;

/**
 * 数据库信息
 *
 * @author lufeifan
 * @date 2021/10/25 18:34
 **/
@Data
public class DbInfo {

    /**
     *  数据库用户名
     **/
    private String username;
    /**
     *  数据库密码
     **/
    private String password;
    /**
     *  数据库地址
     **/
    private String url;
    /**
     *  数据库驱动
     **/
    private String driverName;

}
