package com.my.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.common.dao.SysResourcesMapper;
import com.my.common.model.SysResources;
import com.my.common.model.SysResourcesExample;
import com.my.resource.dao.SysResourceDao;
import com.my.resource.model.SysResource;
import com.my.resource.service.SysResourceService;

@Service("sysResourcesService")
public class SysResourceServiceImpl implements SysResourceService {

	@Autowired
	private SysResourcesMapper sysResourcesMapper;
	@Autowired
	private SysResourceDao sysResourceDao;

	public void save(SysResources resource) {
		sysResourcesMapper.insert(resource);
	}

	public List<SysResources> findAll() {
		SysResourcesExample example = null;
		return sysResourcesMapper.selectByExample(example);
	}

	public List<SysResource> findAuthAll() {
		return sysResourceDao.findAll();
	}

}