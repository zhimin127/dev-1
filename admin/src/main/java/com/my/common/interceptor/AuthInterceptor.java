package com.my.common.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.my.utils.Constants;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private Logger log = Logger.getLogger(AuthInterceptor.class);
	protected  String[] ignoreUrl;

	public void setIgnoreUrl(String[] ignoreUrl) {
		this.ignoreUrl = ignoreUrl;
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//log.info("==============执行顺序: [3] afterCompletion================");
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//log.info("==============执行顺序: [2] postHandle================");
		super.preHandle(request, response, handler);
	}

	/**
	 * 在业务处理器处理请求之前被调用
	 * 
	 * 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		log.info("REQUEST URL:[" + request.getRequestURL().toString() + "] ["+new Date()+"] Start Time:[" + startTime+"]");
		//获取url地址  
        String reqUrl=request.getRequestURI().replace(request.getContextPath(), "");  
        for (String s : ignoreUrl) {
            if (reqUrl.contains(s)) {
            	return true;
            }
        }
		//request.setAttribute("startTime", startTime);
		//request.setCharacterEncoding("UTF-8");  
        //response.setCharacterEncoding("UTF-8");  
        //response.setContentType("text/html;charset=UTF-8");
		Object isLogin = request.getSession().getAttribute(Constants.LOGIN_USER);
		if (null == isLogin) {
            // 未登录  跳转到登录页面  
            //throw new SessionTimeoutException();//返回到配置文件中定义的路径  
			response.sendRedirect(request.getContextPath() +"/login.html");  
			return false;
		}
		return super.preHandle(request, response, handler);
	}
	

}
