package com.fpoly.java4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.java4.dao.ImageDAO;

@WebServlet("/remove-image")
public class RemoveImagePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("imageId");
	String prodId = req.getParameter("prodId");

	ImageDAO.delete(id);

	try {
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	resp.sendRedirect(req.getContextPath() + "/add-product?productId=" + prodId);
    }
}
