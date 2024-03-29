package com.hnfnu.zyw.filter;

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
import com.hnfnu.zyw.utils.Url;

public class LoginFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session = request.getSession(true);
		UserDto user = (UserDto) session.getAttribute("user");
		String url = request.getRequestURI();
		//System.out.println("filter"+url);
		//System.out.println(user);
		if (user == null) {
			if (url != null
					&& (!url.contains("login") && !url.contains("website")) && !url.contains("html2")) {
				response.sendRedirect(Url.LOGINPATH);
				return;
			}
		}
		arg2.doFilter(arg0, arg1);
    }

	public void init(FilterConfig arg0) throws ServletException {
		//System.out.println("LoginFilter init");
	}

}
