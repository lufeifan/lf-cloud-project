package com.lf.generate.config;

/**
 * 类型
 *
 * @author lufeifan
 * @date 2021/10/29 00:57
 **/
public enum Type {

    MAPPER("mapper"),
    ENTITY("entity"),
    SERVER("server"),
    SERVICE_IMPL("Impl"),
    API("api"),
    VUE("vue"),
    UPDATE_ADD("addOrUpdate"),
    SQl("sql");

    private String type;

    /**
     * 类型
     * @param type
     */
    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
