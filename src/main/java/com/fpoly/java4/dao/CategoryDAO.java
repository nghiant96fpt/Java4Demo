package com.fpoly.java4.dao;

import java.util.ArrayList;
import java.util.List;

import com.fpoly.java4.config.EntityConfig;
import com.fpoly.java4.models.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CategoryDAO {

    public static List<Category> findAll() {
	try {
	    EntityManager manager = EntityConfig.getEntityManager();
	    String sql = "SELECT c FROM Category c";
	    TypedQuery<Category> query = manager.createQuery(sql, Category.class);

	    return query.getResultList();
	} catch (Exception e) {
	    e.printStackTrace();
	    return new ArrayList<Category>();
	}
    }

    public static Category findById(String id) {
	try {
	    EntityManager manager = EntityConfig.getEntityManager();
	    Category category = manager.find(Category.class, id);
	    return category;
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
}
