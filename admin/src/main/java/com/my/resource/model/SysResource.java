package com.my.resource.model;

import java.util.List;

import com.my.common.model.SysResources;
import com.my.common.model.SysRoles;
import com.my.common.model.SysStyles;

public class SysResource extends SysResources {

	private List<SysRoles> roles;
	
	private List<SysStyles> styles;

	public List<SysStyles> getStyles() {
		return styles;
	}

	public void setStyles(List<SysStyles> styles) {
		this.styles = styles;
	}

	public List<SysRoles> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoles> roles) {
		this.roles = roles;
	}
}
