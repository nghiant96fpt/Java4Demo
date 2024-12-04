package com.fpoly.java4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.java4.config.EntityConfig;

@WebServlet("/")
public class HomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//	EntityManagerFactory factory = Persistence.createEntityManagerFactory("FPolyDemo");
	EntityConfig.getEntityManager();
	req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }
}
