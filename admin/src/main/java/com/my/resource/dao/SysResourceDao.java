package com.my.resource.dao;

import java.util.List;

import com.my.common.base.BaseDao;
import com.my.resource.model.SysResource;

public interface SysResourceDao extends BaseDao<SysResource> {

	List<SysResource> findAllAuth();

}
