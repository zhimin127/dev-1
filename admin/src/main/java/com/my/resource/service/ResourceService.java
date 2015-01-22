package com.my.resource.service;

import java.util.List;

import com.my.common.model.SysResources;

public interface ResourceService {

	void sava(SysResources resource);
	
	List<SysResources> findAll();
}
