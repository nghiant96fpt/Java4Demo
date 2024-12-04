package com.fpoly.java4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.fpoly.java4.beans.ProductBean;
import com.fpoly.java4.dao.CategoryDAO;
import com.fpoly.java4.dao.ProductDAO;
import com.fpoly.java4.models.Category;
import com.fpoly.java4.models.Image;
import com.fpoly.java4.models.Product;
import com.fpoly.java4.services.UploadFileService;

@MultipartConfig
@WebServlet("/add-product")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Category> categories = CategoryDAO.findAll();
	req.setAttribute("categories", categories);

	String prodId = req.getParameter("productId");

	if (prodId != null) {
	    Product product = ProductDAO.findById(prodId);

	    req.setAttribute("prod", product);
	}

	req.getRequestDispatcher("/views/add-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
	    List<Category> categories = CategoryDAO.findAll();
	    req.setAttribute("categories", categories);

	    ProductBean bean = new ProductBean();
	    Map<String, String[]> map = req.getParameterMap();
	    BeanUtils.populate(bean, map);

	    List<Part> parts = req.getParts().stream().toList();

	    List<Image> images = new ArrayList<Image>();

	    for (Part part : parts) {
		if (part.getContentType() != null && part.getContentType().contains("image")) {
		    String fileName = UploadFileService.uploadFile(req, part);
		    Image image = new Image();
		    image.setName(fileName);
		    images.add(image);
		}
	    }

	    Product product = new Product();
	    product.setName(bean.getName());
	    product.setPrice(bean.getPrice());
	    product.setQuantity(bean.getQuantity());
	    product.setImages(images);

	    Category category = CategoryDAO.findById(String.valueOf(bean.getCatId()));

	    product.setCategory(category);

	    if (bean.getId() != 0) {
		product.setId(bean.getId());
		ProductDAO.update(product);
	    } else {
		ProductDAO.insert(product);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	req.getRequestDispatcher("/views/add-product.jsp").forward(req, resp);
    }
}
