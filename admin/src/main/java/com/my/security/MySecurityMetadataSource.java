package com.my.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.my.common.model.SysRoles;
import com.my.resource.model.SysResource;
import com.my.resource.service.SysResourceService;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	protected final Log logger = LogFactory.getLog(getClass());

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	@Autowired
	private SysResourceService sysResourcesService;

	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		logger.info("====================== 3.返回所请求资源所需要的权限 !======================");
		String url = ((FilterInvocation) object).getRequestUrl();
		logger.info("请求资源 : " + url);
		if (resourceMap == null) {
			loadSysResources();
		}
		if (url.indexOf("?") > -1) {
			url = url.substring(0, url.indexOf("?"));
		}
		logger.info("资源[ " + resourceMap.get(url) + " ]");

		return resourceMap.get(url);
	}

	/**
	 * @PostConstruct是Java EE 5引入的注解， Spring允许开发者在受管Bean中使用它。当DI容器实例化当前受管Bean时，
	 * 
	 * @PostConstruct注解的方法会被自动触发，从而完成一些初始化工作
	 * 
	 * @author zhimin 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
	 *         关联代码：applicationContext-security.xml
	 *         关联代码：com.my.security.MyUserDetailServiceImpl
	 *         #obtionGrantedAuthorities
	 */
	@PostConstruct
	private void loadSysResources() {
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<SysResource> resources = sysResourcesService.getAllAuth();
			for (SysResource resource : resources) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				for (SysRoles role : resource.getRoles()) {
					ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + role.getRoleName());
					configAttributes.add(configAttribute);
				}
				resourceMap.put(resource.getResourcePath(), configAttributes);
			}
			logger.info("资源[ " + resourceMap + " ]");
		}
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
