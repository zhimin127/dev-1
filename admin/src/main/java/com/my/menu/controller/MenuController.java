package com.my.menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.common.model.SysRoles;
import com.my.resource.model.SysResource;
import com.my.resource.service.SysResourceService;
import com.my.utils.Constants;

@RestController
@RequestMapping("menu")
public class MenuController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SysResourceService sysResourceService;

	private Map<String, Object> result;

	@RequestMapping("nav")
	public Map<String, Object> login(HttpServletRequest request) {
		result = new HashMap<String, Object>();
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		SysRoles role = (SysRoles) request.getSession().getAttribute(Constants.CURRENT_ROLE);
		List<SysResource> nav = sysResourceService.getNavResourceByRoleId(role.getRoleId());
		result.put("menus", nav);
		return result;
	}

}
