package com.my.role.service;

import com.my.common.model.SysRoles;

public interface RoleService {
	
	/**
	 * 
	 * @param role
	 */
	public void save(SysRoles role);

	/**
	 * 
	 * @param record
	 */
	public void addUserRole(String userId, String roleId);
}
