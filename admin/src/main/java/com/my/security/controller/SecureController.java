package com.my.security.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("secure")
public class SecureController {

	@RequestMapping
	public ModelAndView secure(Model model) {
		return new ModelAndView("secure/index");
	}

	@RequestMapping("extreme")
	public ModelAndView extreme(Model model) {
		return new ModelAndView("secure/extreme/index");
	}

}
