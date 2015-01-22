package com.my.module.service;

import java.util.List;

import com.my.common.model.SysModules;

public interface ModuleService {

	void sava(SysModules module);

	List<SysModules> findAll();

}
