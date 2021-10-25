package com.lf.test.controller;

import com.lf.common.core.utils.R;
import com.lf.test.feign.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lufeifan
 * @date 2021/10/22 10:17
 **/
@RestController
public class TestController {

    @Autowired
    private HelloFeign helloFeign;

    @GetMapping("/feign/test")
    public R test(){
        System.out.println(helloFeign.test());
        return R.ok();
    }
}
