package com.fpoly.java4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.java4.dao.AddressesDAO;
import com.fpoly.java4.models.Address;

@WebServlet("/addresses")
public class AddressesPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String userId = req.getParameter("userId");
	List<Address> addresses = AddressesDAO.findByUserId(userId);
	req.setAttribute("addresses", addresses);
	req.setAttribute("userId", userId);
	req.getRequestDispatcher("/views/addresses.jsp").forward(req, resp);
    }
}
