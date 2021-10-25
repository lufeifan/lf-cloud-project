package com.lf.common.mybatisPlus;

import com.lf.common.mybatisPlus.config.MyMetaObjectHandler;
import org.springframework.context.annotation.Import;

/**
 * mybatisPlus自动装配
 *
 * @author lufeifan
 * @date 2021/10/22 11:38
 **/
@Import(MyMetaObjectHandler.class)
public class LfMybatisPlusAutoConfiguration {

}
