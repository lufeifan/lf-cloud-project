package com.lf.generate.entity;

import lombok.Data;

import java.util.List;

/**
 * 生成信息
 *
 * @author lufeifan
 * @date 2021/10/25 19:41
 **/
@Data
public class GenerateInfo {
    /**
     * 数据库配置信息
     */
    private DbInfo dbInfo;

    /**
     * 生成表信息
     */
    private List<TableInfo> tableInfo;

    /**
     * 生成列信息
     */
    private List<ColumnInfo> columnInfos;

}
