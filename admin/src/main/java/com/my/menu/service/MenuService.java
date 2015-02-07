package com.my.menu.service;

import java.util.List;

import com.my.menu.model.MenuModel;

public interface MenuService{

	List<MenuModel> getMenuByUser(MenuModel model);

	List<MenuModel> getAll();

}
