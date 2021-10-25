package com.lf.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName sys_log
 */
@TableName(value ="sys_log")
@Data
public class SysLog implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 访问地址
     */
    private String url;

    /**
     * 访问方式
     */
    private String method;

    /**
     * 访问者
     */
    private String username;

    /**
     * 访问时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 是否删除 0未删除，1删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    private String applicationName;

    private String title;
}