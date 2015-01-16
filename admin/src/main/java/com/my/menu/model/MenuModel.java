package com.my.menu.model;

import java.util.List;

public class MenuModel{
	
	private List<MenuModel> subMenu;

	public List<MenuModel> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuModel> subMenu) {
		this.subMenu = subMenu;
	}

}
