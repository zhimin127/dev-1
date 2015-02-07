package com.my.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.common.model.SysUsers;
import com.my.plugin.PageInfo;
import com.my.user.service.SysUserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private SysUserService userService;

	private Map<String, Object> result;

	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("user/account");
	}

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> getUserList(int rows, int page) {
		result = new HashMap<String, Object>();
		PageInfo<SysUsers> pageUser = userService.getPage(page, rows);
		result.put("total", pageUser.getTotal());
		result.put("rows", pageUser.getList());
		return result;
	}

	@RequestMapping("new")
	public Map<String, Object> save(SysUsers user) {
		result = new HashMap<String, Object>();
		//user.setUserType("0");
		userService.save(user);
		result.put("success", true);
		return result;
	}

	@RequestMapping("{username}")
	public SysUsers getUser(@PathVariable String username) {
		return userService.findByName(username);
	}

	@RequestMapping("{id}/edit")
	public Map<String, Object> saveAndUpdate(SysUsers user) {
		result = new HashMap<String, Object>();
		userService.update(user);
		result.put("success", true);
		return result;
	}

}
