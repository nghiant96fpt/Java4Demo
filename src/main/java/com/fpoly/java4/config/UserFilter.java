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

import com.fpoly.java4.dao.UserDAO;
import com.fpoly.java4.models.User;

@WebFilter(filterName = "userFilter", urlPatterns = { "/addresses",
	"/add-address" }, dispatcherTypes = DispatcherType.REQUEST)
public class UserFilter implements HttpFilter {

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

	Cookie[] cookies = req.getCookies();

	if (cookies != null) {
	    String role = null;
	    String username = null;

	    for (Cookie cookie : cookies) {
		if (cookie.getName().equals("role")) {
		    role = cookie.getValue();
		}

		if (cookie.getName().equals("username")) {
		    username = cookie.getValue();
		}
	    }

	    if (role == null || role.equals("1")) {
		chain.doFilter(req, resp);
		return;
	    }

	    if (role == null || !role.equals("0")) {
		resp.sendRedirect(req.getContextPath() + "/login");
		return;
	    } else {
		String userId = req.getParameter("userId");

		User user = UserDAO.findById(userId);

		if (user == null || !user.getUsername().equals(username)) {
		    resp.sendRedirect(req.getContextPath() + "/login");
		    return;
		}
	    }
	} else {
	    resp.sendRedirect(req.getContextPath() + "/login");
	    return;
	}

	System.out.println("Start filter");
	chain.doFilter(req, resp);
    }

    void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	Cookie[] cookies = req.getCookies();

	if (cookies != null) {
	    for (Cookie cookie : cookies) {
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
	    }
	}

	resp.sendRedirect(req.getContextPath() + "/login");
    }
}
