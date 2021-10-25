package com.lf.common.resource.auth.intercept;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author lufeifan
 */
public class PermissionService {

	private static final String ADMIN = "admin";

	/**
	 * 判断接口是否有xxx:xxx权限
	 * @param permission 权限
	 * @return {boolean}
	 */
	public boolean hasPermission(String permission) {
		if (permission.isEmpty()) {
			return false;
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}
//		是管理员放行
		if (ADMIN.equals(authentication.getName())) {
			return true;
		}
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		System.out.println(authorities.stream().map(GrantedAuthority::getAuthority).filter(StringUtils::hasText).collect(Collectors.toList()));
		return authorities.stream().map(GrantedAuthority::getAuthority).filter(StringUtils::hasText)
				.anyMatch(x -> PatternMatchUtils.simpleMatch(permission, x));
	}

}