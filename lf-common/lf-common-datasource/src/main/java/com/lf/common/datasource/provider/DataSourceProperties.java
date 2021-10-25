package com.lf.common.datasource.provider;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DataSource配置文件
 *
 * @author lufeifan
 * @date 2021/10/21 22:07
 **/
@Data
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * jdbcurl
     */
    private String url;

    /**
     * 驱动类型
     */
    private String driverClassName;

    /**
     * 查询数据源的SQL
     */
    private String queryDsSql = "select * from gen_datasource_conf where del_flag = 0";
}
