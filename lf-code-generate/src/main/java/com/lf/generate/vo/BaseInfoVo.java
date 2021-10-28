package com.lf.generate.vo;

import com.lf.generate.entity.DbInfo;
import com.lf.generate.entity.PackInfo;
import lombok.Data;

/**
 * 默认配置
 *
 * @author lufeifan
 * @date 2021/10/28 19:12
 **/
@Data
public class BaseInfoVo {

    private DbInfo dbInfo;

    private PackInfo packInfo;

}
