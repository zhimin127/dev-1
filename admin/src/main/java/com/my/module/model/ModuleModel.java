package com.my.module.model;

import java.util.List;

import com.my.common.model.SysModules;
import com.my.common.model.SysRoles;

public class ModuleModel extends SysModules{

	private List<SysRoles> roles;

	public List<SysRoles> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoles> roles) {
		this.roles = roles;
	}
}
