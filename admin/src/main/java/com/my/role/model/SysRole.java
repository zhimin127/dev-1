package com.my.role.model;

import java.util.List;

import com.my.common.model.SysAuthorities;
import com.my.common.model.SysResources;
import com.my.common.model.SysRoles;

public class SysRole extends SysRoles {

	private List<SysResources> resources;
	private List<SysAuthorities> authorities;

	public List<SysResources> getResources() {
		return resources;
	}

	public void setResources(List<SysResources> resources) {
		this.resources = resources;
	}

	public List<SysAuthorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<SysAuthorities> authorities) {
		this.authorities = authorities;
	}
}
