package com.lf.system.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lf.common.entity.SysUser;
import com.lf.common.vo.UserDetail;
import com.lf.system.admin.service.SysUserService;
import com.lf.system.admin.mapper.SysUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lufeifan
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
implements SysUserService{

    @Override
    public UserDetails userInfo(String username) {
        SysUser user = this.baseMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(user, userDetail);

        List<String> list = new ArrayList<>();
        list.add("system:admin:show");
        userDetail.setRole(list);
        return userDetail;
    }
}




