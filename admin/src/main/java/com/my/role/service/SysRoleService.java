package com.my.role.service;

import com.my.common.model.SysRoles;

public interface SysRoleService {
	
	/**
	 * 
	 * @param role
	 */
	public void save(SysRoles role);

	public SysRoles getRoleByName(String name);

	public void saveRoleResource(String roleId, String resourceId);

}
