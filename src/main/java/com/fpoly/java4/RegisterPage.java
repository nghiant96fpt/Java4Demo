package com.fpoly.java4;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.fpoly.java4.beans.UserBean;
import com.fpoly.java4.dao.UserDAO;
import com.fpoly.java4.models.User;

@WebServlet("/register")
public class RegisterPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	if (id != null) {
	    User user = UserDAO.findById(id);

	    UserBean userBean = new UserBean();
	    userBean.setId(user.getUserId());
	    userBean.setUsername(user.getUsername());
	    userBean.setName(user.getName());
	    userBean.setAddress(user.getAddress());
	    userBean.setEmail(user.getEmail());
	    userBean.setPassword(user.getPassword());
	    req.setAttribute("user", userBean);
	}

	req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
	    Map<String, String[]> map = req.getParameterMap();
	    UserBean userBean = new UserBean();
	    BeanUtils.populate(userBean, map);
	    req.setAttribute("user", userBean);

	    User user = UserDAO.findByUsername(userBean.getUsername());

	    if (user != null && userBean.getId() != user.getUserId()) {
		req.setAttribute("error", "Username");
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		return;
	    }

	    User userEntity = new User();
	    userEntity.setUsername(userBean.getUsername());
	    userEntity.setPassword(userBean.getPassword());
	    userEntity.setName(userBean.getName());
	    userEntity.setEmail(userBean.getEmail());
	    userEntity.setAddress(userBean.getAddress());

	    HttpSession session = req.getSession();

//	    ServletContext context = this.getServletContext();
//	    ServletContext context = session.getServletContext();
	    ServletContext context = req.getServletContext();

	    if (userBean.getId() != 0) {
		userEntity.setUserId(userBean.getId());
		UserDAO.updateUser(userEntity);
//		session.setAttribute("msgUser", "User updated");
		context.setAttribute("msgUser", "User updated");
	    } else {
		UserDAO.insertUser(userEntity);
//		session.setAttribute("msgUser", "Register success");
		context.setAttribute("msgUser", "Register success");
	    }

	    resp.sendRedirect(req.getContextPath() + "/users");
	    return;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }
}
