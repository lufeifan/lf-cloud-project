package com.lf.common.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lufeifan
 */
@Data
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {
    private Boolean enabled;
}
