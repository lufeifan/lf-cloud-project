package com.lf.system.admin.controller;

import com.lf.common.core.utils.R;
import com.lf.system.admin.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lufeifan
 */
@Api
@RestController
@RequestMapping("/admin")
public class InfoController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 用户信息，通过 openFeign被其他服务调用
     **/
    @ApiOperation(value = "通过同户名获取用户信息")
    @GetMapping("/one")
    @ApiImplicitParam(name = "username", required = true, value = "用户名")
    public R user(@RequestParam("username") String username) {
        UserDetails value = sysUserService.userInfo(username);
        return R.setData(value);
    }
}
