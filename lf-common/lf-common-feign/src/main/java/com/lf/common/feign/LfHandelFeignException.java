package com.lf.common.feign;

import com.lf.common.core.utils.R;
import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lufeifan
 * @date 2021/10/22 10:58
 **/
@RestControllerAdvice
public class LfHandelFeignException {

    @ExceptionHandler(FeignException.class)
    public R handle(FeignException e){
        if (e instanceof FeignException.ServiceUnavailable){
            return R.error("资源不存在");
        }
        e.printStackTrace();
        return R.error(e.getMessage());
    }
}
