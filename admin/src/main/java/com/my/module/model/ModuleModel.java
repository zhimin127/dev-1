package com.my.module.model;

import java.util.List;

import com.my.common.model.SysModules;
import com.my.common.model.SysRoles;

public class ModuleModel extends SysModules{

	private List<SysRoles> roles;
	
	private List<ModuleModel> subModules;

	public List<SysRoles> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoles> roles) {
		this.roles = roles;
	}

	public List<ModuleModel> getSubModules() {
		return subModules;
	}

	public void setSubModules(List<ModuleModel> subModules) {
		this.subModules = subModules;
	}
}
