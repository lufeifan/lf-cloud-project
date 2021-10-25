package com.lf.common.core.utils;

/**
 * 统一响应状态码
 */
public enum MessageStatus {
    /* 成功状态码（默认） */
    SUCCESS(1, "操作成功"),
    /* 失败状态码（默认） */
    ERROR(2, "操作失败"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),


    /* 用户错误：20001-29999*/
    USER_TOKEN_NOT_EXIST(20001, "用户未登录"),
    USER_TOKEN_INVALID(20002, "token无效"),
    USER_LOGIN_ERROR(20003, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20004, "账号已被禁用"),
    USER_NOT_EXIST(20005, "用户不存在"),
    USER_HAS_EXISTED(20006, "用户已存在"),
    USER_NOT_EMPTY(20007, "用户名不能为空"),
    USER_PASSWORD_ERROR(20008, "密码错误"),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_ERROR(30001, "业务逻辑出现问题"),
    SPECIFIED_QUESTIONED_ADNIN_FORBID_DEL(30002, "管理员不能删除"),
    SPECIFIED_QUESTIONED_CONFIG_NOT_EXIST(30003, "配置信息不存在"),
    SPECIFIED_QUESTIONED_CONFIG_ID_NOT_NULL(30004, "配置信息的id不能为空"),
    SPECIFIED_QUESTIONED_CAROUSEL_NOT_EXIST(30005, "轮播图不存在"),
    SPECIFIED_QUESTIONED_CATEGORY_NOT_EXIST(30006, "栏目不存在"),
    SPECIFIED_QUESTIONED_ARTICLE_NOT_EXIST(30007, "咨询不存在"),
    SPECIFIED_QUESTIONED_COMMENT_NOT_EXIST(30008, "评论不存在"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统内部错误，请稍后重试"),

    /* 数据错误：50001-599999 */
    DATA_NONE(50001, "数据未找到"),
    DATA_WRONG(50002, "数据错误"),
    DATA_EXISTED(50003, "数据已存在"),


    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),

    /* 权限错误：70001-79999 */
    PERMISSION_NOT_ADMIN(70001, "当前用户不是管理员"),
    PERMISSION_NO_ACCESS(70002, "无访问权限"),
    PERMISSION_NOT_DELETE(70003,"非管理员无删除权限"),
    PERMISSION_NOT_UPDATE(70004,"非管理员无更新权限"),
    PERMISSION_NOT_SAVE(70005,"非管理员无写入权限");

    private Integer code;

    private String message;

    MessageStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
