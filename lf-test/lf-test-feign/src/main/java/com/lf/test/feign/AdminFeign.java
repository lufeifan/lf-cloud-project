package com.lf.test.feign;

import com.lf.common.core.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "lf-system-admin")
public interface AdminFeign {

    @GetMapping("/admin/one")
    R user(@RequestParam("username") String username);
}
