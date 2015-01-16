package com.my.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.user.service.UserService;

@RestController
public class HomeController{

	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
}
