package com.my.user.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.common.base.impl.BaseDaoImpl;
import com.my.user.dao.SysUserDao;
import com.my.user.model.SysUser;

@Repository("sysUserDao")
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {

	public SysUser findByUserName(String username) {
		return getSqlSession().selectOne("SysUser.findByUsername", username);
	}

	public void addUserRole(Map<String, String> record) {
		getSqlSession().insert("UserRole.addUserRole", record);
	}

}
