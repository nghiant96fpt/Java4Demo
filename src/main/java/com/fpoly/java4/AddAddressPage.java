package com.fpoly.java4;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fpoly.java4.beans.AddressBean;
import com.fpoly.java4.dao.AddressesDAO;
import com.fpoly.java4.dao.UserDAO;
import com.fpoly.java4.models.Address;
import com.fpoly.java4.models.User;

@WebServlet("/add-address")
//add-address?userId=5
public class AddAddressPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// lấy params có key là userId
	// send attribiute qua jsp

	String userId = req.getParameter("userId");
	req.setAttribute("userId", userId);
	req.getRequestDispatcher("/views/add-address.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
	    Map<String, String[]> map = req.getParameterMap();
	    AddressBean addressBean = new AddressBean();
	    BeanUtils.populate(addressBean, map);

	    // Bat loi

	    Address address = new Address();
	    address.setCustomerName(addressBean.getCustomerName());
	    address.setPhoneNumber(addressBean.getPhoneNumber());
	    address.setAddress(addressBean.getAddress());

	    User user = UserDAO.findById(addressBean.getUserId());
	    address.setUser(user);

	    AddressesDAO.insertAddress(address);

	    // Quay ve trang danh sach dia chi
	    resp.sendRedirect(req.getContextPath() + "/addresses?userId=" + addressBean.getUserId());
	    return;

	} catch (Exception e) {
	    e.printStackTrace();
	}
	req.getRequestDispatcher("/views/add-address.jsp").forward(req, resp);
    }
}
