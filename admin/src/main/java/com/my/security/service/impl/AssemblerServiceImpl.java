package com.my.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.common.model.SysRoles;
import com.my.security.service.AssemblerService;
import com.my.user.model.SysUser;

@Service("assemblerService")
public class AssemblerServiceImpl implements AssemblerService {
    
	@Transactional(readOnly = true)
	public User buildUserFromUserEntity(SysUser userAccount) {
		String username = userAccount.getUsername();
		String password = userAccount.getPassword();
		boolean enabled = userAccount.isActive();
		boolean accountNonExpired = userAccount.isExpired();
		boolean credentialsNonExpired = userAccount.isAuthExpired();
		boolean accountNonLocked = userAccount.isLocked();

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (SysRoles role : userAccount.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}

		return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
}
