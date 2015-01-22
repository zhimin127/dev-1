package com.my.module.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.common.dao.SysModulesMapper;
import com.my.common.model.SysModules;
import com.my.module.service.ModuleService;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
	
	protected Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SysModulesMapper sysModulesMapper;
	
	public void sava(SysModules module) {
		sysModulesMapper.insert(module);
	}

	public List<SysModules> findAll() {
		logger.info("============================== find all modules...");
		return sysModulesMapper.selectByExample(null);
	}

}
