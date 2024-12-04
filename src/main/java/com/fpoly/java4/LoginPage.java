package com.fpoly.java4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.java4.dao.UserDAO;
import com.fpoly.java4.models.User;

@WebServlet("/login")
public class LoginPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String username = req.getParameter("username");
	String password = req.getParameter("password");

	User user = UserDAO.findByUsername(username);

	if (user.getPassword().equals(password)) {

	    Cookie cookieUsername = new Cookie("username", user.getUsername());
	    cookieUsername.setMaxAge(60 * 60 * 24 * 10);
	    cookieUsername.setPath("/");

	    Cookie cookieRole = new Cookie("role", String.valueOf(user.getRole()));
	    cookieRole.setMaxAge(60 * 60 * 24 * 10);
	    cookieRole.setPath("/");

	    resp.addCookie(cookieRole);
	    resp.addCookie(cookieUsername);

	    if (user.getRole() == 1) {
		resp.sendRedirect(req.getContextPath() + "/admin/users");
		return;
	    } else {
		resp.sendRedirect(req.getContextPath() + "/addresses?userId=" + user.getUserId());
		return;
	    }
	}

	req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }
}
