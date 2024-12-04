package com.fpoly.java4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.java4.dao.UserDAO;
import com.fpoly.java4.models.User;

@WebServlet("/admin/users")
public class UsersPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<User> users = UserDAO.getAllUser();

	System.out.println("Start users page");
//	HttpSession session = req.getSession();
	ServletContext context = req.getServletContext();
	if (context.getAttribute("msgUser") != null) {
	    String msg = String.valueOf(context.getAttribute("msgUser"));
	    req.setAttribute("msg", msg);
	    context.removeAttribute("msgUser");
	}
	req.setAttribute("users", users);
	req.getRequestDispatcher("/views/users.jsp").forward(req, resp);
    }
}
