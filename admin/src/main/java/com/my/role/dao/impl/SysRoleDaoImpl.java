package com.my.role.dao.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.my.common.base.impl.BaseDaoImpl;
import com.my.enums.MapperEnum;
import com.my.role.dao.SysRoleDao;
import com.my.role.model.SysRole;

@Repository("sysRoleDao")
public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements SysRoleDao {

	protected final Log logger = LogFactory.getLog(getClass());

	public void saveRoleResource(Map<String, String> record) {
		if (this.findUserResource(record) == null) {
			getSqlSession().insert(MapperEnum.SYS_ROLE.getMapperName() + ".insertRoleResource", record);
		}
	}

	public String findUserResource(Map<String, String> record) {
		Object id = getSqlSession().selectOne(MapperEnum.SYS_ROLE.getMapperName() + ".findRoleResourceByRoleIdAndResourceId", record);
		logger.info(id);
		return (String) id;
	}

}
