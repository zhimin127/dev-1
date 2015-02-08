package com.my.user.dao.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.my.common.base.impl.BaseDaoImpl;
import com.my.enums.MapperEnum;
import com.my.user.dao.SysUserDao;
import com.my.user.model.SysUser;

@Repository("sysUserDao")
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {

	protected final Log logger = LogFactory.getLog(getClass());

	public SysUser findByUserName(String username) {
		return getSqlSession().selectOne(MapperEnum.SYS_USER.getMapperName() + ".findByUsername", username);
	}

	public void addUserRole(Map<String, String> record) {
		Object id = getSqlSession().selectOne(MapperEnum.SYS_USER.getMapperName() + ".findUserRoleByUserIdAndRoleId", record);
		logger.info(id);
		if (id == null) {
			getSqlSession().insert(MapperEnum.SYS_USER.getMapperName() + ".insertUserRole", record);
		}
	}

}
