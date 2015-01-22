package com.my.security;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		return null;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}
