package com.hnfnu.zyw.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hnfnu.zyw.dto.system.UserDto;

public class LoginFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session = request.getSession(true);
		UserDto user = (UserDto) session.getAttribute("user");
		String url = request.getRequestURI();
		System.out.println("我是filter"+url);
		System.out.println(user);
		if (user == null) {
			System.out.println("已经登录");
			// 判断获取的路径不为空且不是访问登录页面或执行登录操作时跳转
			if (url != null && !url.equals("")
					&& (url.indexOf("login") < 0 && url.indexOf("login") < 0)) {
				response.sendRedirect("http://localhost:8080/hnfnuzyw/login.html");
				return;
			}
		}
		// 已通过验证，用户访问继续
		arg2.doFilter(arg0, arg1);
		return;
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
