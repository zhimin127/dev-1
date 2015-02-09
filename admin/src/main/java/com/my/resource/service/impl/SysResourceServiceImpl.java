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

	public List<SysResources> getAll() {
		return sysResourcesMapper.selectByExample(null);
	}

	public List<SysResource> getAllAuth() {
		return sysResourceDao.findAllAuth();
	}

	public List<SysResource> getNavResourceByRoleId(String roleId) {
		return sysResourceDao.findNavResourceByRoleId(roleId);
	}

	public SysResources getByTypeAndResourceName(String resourceType, String resourceName) {
		SysResourcesExample example = new SysResourcesExample();
		example.createCriteria().andResourceTypeEqualTo(resourceType).andResourceNameEqualTo(resourceName);
		List<SysResources> resources = sysResourcesMapper.selectByExample(example);
		if (resources.size() > 0) {
			return resources.get(0);
		}
		return null;
	}

	public List<SysResource> getByT(SysResource resource) {
		return sysResourceDao.findByT(resource);
	}

	public List<SysResource> getPageByT(SysResource resource, int page, int pageSize) {
		return sysResourceDao.findPageByT(resource, page, pageSize);
	}
}
