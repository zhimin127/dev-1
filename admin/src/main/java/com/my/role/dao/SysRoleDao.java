package com.my.role.dao;

import java.util.Map;

import com.my.common.base.BaseDao;
import com.my.role.model.SysRole;

public interface SysRoleDao extends BaseDao<SysRole>{

	void saveRoleResource(Map<String, String> record);

}
