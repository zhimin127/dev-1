package com.my.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MyAuthorizationFilter extends AbstractSecurityInterceptor implements Filter {

	protected final Log logger = LogFactory.getLog(getClass());

	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	public void destroy() {

	}

	/**
	 * super.beforeInvocation(filter) 执行的处理如下:
	 * 1.获取请求资源的权限	:	MySecurityMetadataSource
	 * 	 	Collection<ConfigAttribute> attributes = securityMetadataSource.getAttributes(filter);
	 * 2.是否拥有权限		:	MyAccessDecisionManager
	 * 		1) 获取安全主体，可以强制转换为UserDetails的实例
	 * 		Authentication authenticated = authenticateIfRequired();
	 * 		this.accessDecisionManager.decide(authenticated, filter, attributes);
	 * 		2) 用户拥有的权限GrantedAuthority
	 * 		 Collection<GrantedAuthority> authenticated.getAuthorities()
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("============================== 2.用户发送请求! ============================== ");
		FilterInvocation filter = new FilterInvocation(request, response, chain);
		InterceptorStatusToken token = super.beforeInvocation(filter);
		try {
			filter.getChain().doFilter(filter.getRequest(), filter.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

}
