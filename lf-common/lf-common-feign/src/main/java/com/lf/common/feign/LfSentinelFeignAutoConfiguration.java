package com.lf.common.feign;

import com.alibaba.cloud.sentinel.feign.SentinelFeignAutoConfiguration;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lf.common.feign.sentinel.LfBlockException;
import com.lf.common.feign.sentinel.LfSentinelFeign;
import feign.Feign;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author lufeifan
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({ SphU.class, Feign.class })
@AutoConfigureBefore(SentinelFeignAutoConfiguration.class)
public class LfSentinelFeignAutoConfiguration {

	@Bean
	@Scope("prototype")
	@ConditionalOnMissingBean
	public Feign.Builder feignSentinelBuilder() {
		return LfSentinelFeign.builder();
	}

	@Bean
	public BlockException blockException(){
		return new LfBlockException(null);
	}

}
