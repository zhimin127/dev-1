package com.my.user.dao;

import java.util.Map;

import com.my.common.base.BaseDao;
import com.my.user.model.SysUser;

public interface SysUserDao extends BaseDao<SysUser>{

	public SysUser findByUserName(String username);

	public void addUserRole(Map<String, String> record);

}
