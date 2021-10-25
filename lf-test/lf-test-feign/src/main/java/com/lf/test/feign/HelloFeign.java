package com.lf.test.feign;

import com.lf.common.core.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lufeifan
 * @date 2021/10/22 10:11
 **/
@FeignClient(contextId = "helloFeign",value = "lf-auth")
public interface HelloFeign {

    /**
     * test
     *
     * @return String
     */
    @GetMapping("/hello/test")
    R test();

}
