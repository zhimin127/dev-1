package com.my.module.service;

import java.util.List;

import com.my.common.model.SysModules;
import com.my.module.model.ModuleModel;

public interface ModuleService {

	void sava(SysModules module);

	List<ModuleModel> findAll();

}
