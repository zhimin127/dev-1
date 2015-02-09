package com.my.resource.service;

import java.util.List;

import com.my.common.model.SysResources;
import com.my.resource.model.SysResource;

public interface SysResourceService {

	void save(SysResources resource);
	
	List<SysResources> getAll();

	List<SysResource> getAllAuth();

	List<SysResource> getNavResourceByRoleId(String roleId);

	SysResources getByTypeAndResourceName(String resourceType, String resourceName);

	List<SysResource> getByT(SysResource resource);

	List<SysResource> getPageByT(SysResource resource, int page, int pageSize);
}
