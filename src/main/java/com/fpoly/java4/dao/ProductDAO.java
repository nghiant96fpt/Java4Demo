package com.fpoly.java4.dao;

import java.util.ArrayList;
import java.util.List;

import com.fpoly.java4.config.EntityConfig;
import com.fpoly.java4.models.Image;
import com.fpoly.java4.models.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ProductDAO {

    public static List<Product> findAll() {
	try {
	    EntityManager manager = EntityConfig.getEntityManager();
	    String sql = "SELECT p FROM Product p";
	    TypedQuery<Product> query = manager.createQuery(sql, Product.class);

	    return query.getResultList();
	} catch (Exception e) {
	    e.printStackTrace();
	    return new ArrayList<Product>();
	}
    }

    public static Product findById(String id) {
	try {
	    EntityManager manager = EntityConfig.getEntityManager();
	    String sql = "SELECT p FROM Product p WHERE p.id=:prod_id";
	    TypedQuery<Product> query = manager.createQuery(sql, Product.class);
	    query.setParameter("prod_id", id);

	    return query.getSingleResult();
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }

    public static boolean insert(Product product) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    manager.getTransaction().begin();

	    List<Image> images = product.getImages();

	    manager.persist(product);
	    manager.flush();

	    for (Image image : images) {
		image.setProduct(product);
		manager.persist(image);
	    }

	    manager.getTransaction().commit();

	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    manager.getTransaction().rollback();
	    return false;
	}
    }

    public static boolean update(Product product) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    manager.getTransaction().begin();

	    manager.merge(product);

	    List<Image> images = product.getImages();
	    for (Image image : images) {
		image.setProduct(product);
		manager.persist(image);
	    }
	    manager.getTransaction().commit();

	    return true;
	} catch (Exception e) {
	    manager.getTransaction().rollback();
	    e.printStackTrace();
	    return false;
	}
    }

    public static boolean delete(Product product) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    ImageDAO.deleteByProdId(String.valueOf(product.getId()));

	    manager.getTransaction().begin();
	    manager.remove(product);
	    manager.getTransaction().commit();

	    return true;
	} catch (Exception e) {
	    manager.getTransaction().rollback();
	    e.printStackTrace();
	    return false;
	}
    }
}
