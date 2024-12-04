package com.fpoly.java4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.java4.dao.UserDAO;

@WebServlet("/delete-user")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	UserDAO.deleteUser(id);
	resp.sendRedirect(String.format("%s/users", req.getContextPath()));
    }
}
