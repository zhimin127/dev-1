package com.my.user.model;

import java.util.List;

import com.my.common.model.SysRoles;
import com.my.common.model.SysUsers;

public class UserModel extends SysUsers {

	private List<SysRoles> roles;

	public List<SysRoles> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoles> roles) {
		this.roles = roles;
	}

	public boolean isActive() {
		if (getEnabled() != null && "1".equals(getEnabled())) {
			return true;
		}
		return false;
	}
	
	public boolean isExpired() {
		if(getAccountNonExpired() != null && "1".equals(getAccountNonExpired())){
			return true;
		}
		return false;
	}
	
	public boolean isLocked() {
		if(getAccountNonLocked() != null && "1".equals(getAccountNonLocked())){
			return true;
		}
		return false;
	}

	public boolean isAuthExpired() {
		if(getCredentialsNonExpired() != null && "1".equals(getCredentialsNonExpired())){
			return true;
		}
		return false;
	}
}
