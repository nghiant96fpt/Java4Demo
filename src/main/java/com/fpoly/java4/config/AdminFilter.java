package com.fpoly.java4.config;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "adminRole", urlPatterns = { "/admin/*", "/register", "/delete-user" }, dispatcherTypes = DispatcherType.REQUEST)
public class AdminFilter implements HttpFilter {

    @Override
    public void destroy() {
	// TODO Auto-generated method stub

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	// TODO Auto-generated method stub

    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
	    throws IOException, ServletException {
	// TODO Auto-generated method stub

	// lay Cookie
	// Kiem tra role != 1 => user
	// Chuyen ve trang login

	Cookie[] cookies = req.getCookies();

	if (cookies != null) {
	    String role = null;

	    for (Cookie cookie : cookies) {
		if (cookie.getName().equals("role")) {
		    role = cookie.getValue();
		    break;
		}
	    }

	    if (role == null || !role.equals("1")) {
		resp.sendRedirect(req.getContextPath() + "/login");
		return;
	    }
	} else {
	    resp.sendRedirect(req.getContextPath() + "/login");
	    return;
	}

	System.out.println("Start filter");
	chain.doFilter(req, resp);
    }

}
