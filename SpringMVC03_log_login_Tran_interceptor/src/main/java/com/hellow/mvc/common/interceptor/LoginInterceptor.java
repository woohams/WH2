package com.hellow.mvc.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("[INTERCEPTOR] preHandle");
		
		// spring 3.2 이상 : servlet-context.xml에서 <exclude-mapping-path>를 사용 할 수 있다.
		if(request.getRequestURI().contains("/loginform.do")||request.getRequestURI().contains("/loginajax.do")) {	
			// loginform.do로 넘어오면 interceptor 거치지 않고 바로 보내준다 -> 예외처리 ??
			return true;
		}
		
		if(request.getSession().getAttribute("dto") == null) {
			response.sendRedirect("/interceptor");
			return true;
		}
		
		
		
		//controller 정상 동작 여부
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("[INTERCEPTOR] postHandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		// 브라우저에 화면이 완성된 후에 찍힘
		logger.info("[INTERCEPTOR] afterCompletion");

	}

}
