package com.lf.generate.service;

import com.lf.generate.entity.GenerateInfo;

/**
 * 生成信息接口
 *
 * @author lufeifan
 * @date 2021/10/25 19:45
 **/
public interface GenerateConfigService {
    /**
     * 生成信息配置
     * @param info
     * @return
     */
    GenerateInfo generateConfig(GenerateInfo info);
}
