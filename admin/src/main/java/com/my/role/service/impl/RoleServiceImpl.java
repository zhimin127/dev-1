package com.my.role.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.common.dao.SysRolesMapper;
import com.my.common.model.SysRoles;
import com.my.role.service.RoleService;
import com.my.user.dao.UserDao;
import com.my.utils.UUIDGenerator;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private SysRolesMapper sysRolesMapper;
	@Autowired
	private UserDao userDao;
	
	public void save(SysRoles record) {
		sysRolesMapper.insert(record);
	}

	public void addUserRole(String userId, String roleId) {
		Map<String, String> record = new HashMap<String, String>();
		record.put("id", UUIDGenerator.generate());
		record.put("roleId", roleId);
		record.put("userId", userId);
		userDao.addUserRole(record);
	}

}
