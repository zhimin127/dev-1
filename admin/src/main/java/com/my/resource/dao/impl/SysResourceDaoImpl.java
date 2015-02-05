package com.my.resource.dao.impl;

import org.springframework.stereotype.Repository;

import com.my.common.base.impl.BaseDaoImpl;
import com.my.resource.dao.SysResourceDao;
import com.my.resource.model.SysResource;

@Repository("sysResourceDao")
public class SysResourceDaoImpl extends BaseDaoImpl<SysResource> implements SysResourceDao {

}
