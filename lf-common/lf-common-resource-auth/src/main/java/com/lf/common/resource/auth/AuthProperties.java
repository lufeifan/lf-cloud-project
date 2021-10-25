package com.lf.common.resource.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author lufeifan
 */
@Data
@ConfigurationProperties(prefix = "auth.path")
public class AuthProperties {
    private List<String> list;
}
