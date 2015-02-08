package com.my.user.service;

import com.my.common.model.SysUsers;
import com.my.plugin.PageInfo;
import com.my.user.model.SysUser;

public interface SysUserService {

	void save(SysUsers user);

	void saveOrUpdate(SysUsers user);

	void update(SysUsers user);

	SysUsers getByUsernameAndPassword(String username, String password);

	SysUser getByUsername(String userName);

	PageInfo<SysUsers> getPage(int page, int rows);
	
	/**
	 * 
	 * @param record
	 */
	public void saveUserRole(String userId, String roleId);

}
