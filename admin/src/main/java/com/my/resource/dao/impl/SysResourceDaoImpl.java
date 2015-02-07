package com.my.resource.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.my.common.base.impl.BaseDaoImpl;
import com.my.enums.MapperEnum;
import com.my.resource.dao.SysResourceDao;
import com.my.resource.model.SysResource;

@Repository("sysResourceDao")
public class SysResourceDaoImpl extends BaseDaoImpl<SysResource> implements SysResourceDao {

	protected final Log logger = LogFactory.getLog(getClass());

	public List<SysResource> findAllAuth() {
		return getSqlSession().selectList(MapperEnum.SYS_RESOURCE.getMapperName() + ".findAllAuth");
	}

	public List<SysResource> findNavResourceByRoleId(String roleId) {
		return getSqlSession().selectList(MapperEnum.SYS_RESOURCE.getMapperName() + ".findNavResourceByRoleId", roleId);
	}

}
