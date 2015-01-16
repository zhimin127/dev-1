package com.my.menu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.my.common.base.impl.BaseDaoImpl;
import com.my.menu.model.MenuModel;
import com.my.menu.service.MenuService;

@Service("menuService")
public class MenuServiceImpl extends BaseDaoImpl<MenuModel> implements MenuService {

	public List<MenuModel> getMenuByUser(MenuModel model) {
		return super.findAll(model);
	}

	@Override
	public List<MenuModel> findAll(MenuModel t) {
		return super.findAll(t);
	}

}
