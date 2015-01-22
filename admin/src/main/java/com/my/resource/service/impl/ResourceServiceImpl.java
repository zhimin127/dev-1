package com.my.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.common.dao.SysResourcesMapper;
import com.my.common.model.SysResources;
import com.my.common.model.SysResourcesExample;
import com.my.resource.service.ResourceService;

@Service("resourcesService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private SysResourcesMapper sysResourcesMapper;

	public void sava(SysResources resource) {
		sysResourcesMapper.insert(resource);
	}

	public List<SysResources> findAll() {
		SysResourcesExample example = null;
		return sysResourcesMapper.selectByExample(example);
	}

}
