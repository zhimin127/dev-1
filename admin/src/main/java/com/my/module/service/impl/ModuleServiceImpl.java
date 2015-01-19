package com.my.module.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.common.dao.SysModulesMapper;
import com.my.common.model.SysModules;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private SysModulesMapper sysModulesMapper;
	
	public void sava(SysModules module) {
		sysModulesMapper.insert(module);
	}

}
