package com.my.resource.service;

import java.util.List;

import com.my.common.model.SysResources;
import com.my.resource.model.SysResource;

public interface ResourceService {

	void sava(SysResources resource);
	
	List<SysResources> findAll();

	List<SysResource> findAuthAll();
}
