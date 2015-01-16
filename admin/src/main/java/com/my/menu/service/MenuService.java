package com.my.menu.service;

import java.util.List;

import com.my.common.base.BaseDao;
import com.my.menu.model.MenuModel;

public interface MenuService extends BaseDao<MenuModel>{

	List<MenuModel> getMenuByUser(MenuModel model);

}
