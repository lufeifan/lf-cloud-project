package com.lf.common.vo;

import com.lf.common.entity.SysUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lufeifan
 */
@ToString(callSuper=true)
@Data
@NoArgsConstructor
public class UserDetail extends SysUser implements UserDetails {

    private List<String> role;

//    private List<SysPermission> permission;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        role.stream().forEach(item -> list.add(new SimpleGrantedAuthority(item)));
//        permission.stream().forEach(item -> list.add(new SimpleGrantedAuthority(item.getName())));
        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
