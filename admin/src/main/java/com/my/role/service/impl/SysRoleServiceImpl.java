package com.my.role.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.common.dao.SysRolesMapper;
import com.my.common.model.SysRoles;
import com.my.common.model.SysRolesExample;
import com.my.role.dao.SysRoleDao;
import com.my.role.service.SysRoleService;
import com.my.user.dao.SysUserDao;

@Service("roleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRolesMapper sysRolesMapper;
	@Autowired
	private SysUserDao userDao;
	@Autowired
	private SysRoleDao sysRoleDao;

	public void save(SysRoles record) {
		sysRolesMapper.insert(record);
	}

	public SysRoles getRoleByName(String name) {
		SysRolesExample example = new SysRolesExample();
		example.createCriteria().andRoleNameEqualTo(name);
		List<SysRoles> roles = sysRolesMapper.selectByExample(example);
		if (roles.size() > 0) {
			return roles.get(0);
		}
		return null;
	}

	public void saveRoleResource(String roleId, String resourceId) {
		Map<String, String> record = new HashMap<String, String>();
		record.put("id", UUID.randomUUID().toString());
		record.put("roleId", roleId);
		record.put("resourceId", resourceId);
		sysRoleDao.saveRoleResource(record);
		
	}

}
