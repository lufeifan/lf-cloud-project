package com.lf.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lf.common.entity.SysUser;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author lufeifan
 */
public interface SysUserService extends IService<SysUser> {
    UserDetails userInfo(String username);
}
