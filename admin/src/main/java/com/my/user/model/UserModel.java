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
		if (getEnabled() != null && "1".equals(super.getEnabled())) {
			return true;
		}
		return false;
	}
}
