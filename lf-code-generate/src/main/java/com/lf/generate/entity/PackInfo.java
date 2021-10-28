package com.lf.generate.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 配置信息
 *
 * @author lufeifan
 * @date 2021/10/26 18:26
 **/
@Data
public class PackInfo {

    /**
     *  作者
     **/
    private String userName = "lf-fei-fan";
    /**
     *  生成的时间
     **/
    private String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    /**
     *  作者邮箱
     **/
    private String email = "1714004230@qq.com";
    /**
     *  包名
     **/
    private String packageName = "com.lf.test";
    /**
     *  模块名
     **/
    private String moduleName = "test";
}
