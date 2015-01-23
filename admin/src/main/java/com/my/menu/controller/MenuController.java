package com.my.menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.common.model.SysUsers;
import com.my.menu.model.MenuModel;
import com.my.menu.service.MenuService;
import com.my.utils.Constants;

@RestController
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	private Map<String, Object> result = new HashMap<String, Object>();

	@RequestMapping
	public Map<String, Object> login(HttpServletRequest request) {
		result = new HashMap<String, Object>();

		SysUsers user = (SysUsers) request.getSession().getAttribute(Constants.LOGIN_USER);
		System.out.println(user);
		// List<MenuModel> menu = menuService.getMenuByUser(null);

		List<MenuModel> menus = menuService.findAll();

		result.put("menus", menus);
		return result;
	}

}
