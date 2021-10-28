package com.lf.generate.service;

import com.lf.generate.entity.ColumnInfo;
import com.lf.generate.entity.TableInfo;

import java.util.List;

/**
 * 生成信息接口
 *
 * @author lufeifan
 * @date 2021/10/25 19:45
 **/
public interface GenerateConfigService {
    /**
     * 生成表信息配置
     * @param tableInfo
     * @return
     */
    void classGenerateConfig(TableInfo tableInfo);

    /**
     * 生成列信息配置
     * @param columnInfoList
     */
    void fieldGenerateConfig(List<ColumnInfo> columnInfoList);
}
