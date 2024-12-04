package com.fpoly.java4.dao;

import com.fpoly.java4.config.EntityConfig;
import com.fpoly.java4.models.Image;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ImageDAO {

    public static boolean insert(Image image) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.persist(image);
	    manager.getTransaction().commit();

	    return true;
	} catch (Exception e) {
	    manager.getTransaction().rollback();
	    e.printStackTrace();
	    return false;
	}
    }

    public static boolean delete(String id) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    Image image = manager.find(Image.class, id);

	    manager.getTransaction().begin();
	    manager.remove(image);
	    manager.getTransaction().commit();

	    return true;
	} catch (Exception e) {
	    manager.getTransaction().rollback();
	    e.printStackTrace();
	    return false;
	}
    }

    public static boolean deleteByProdId(String id) {
	try {
	    EntityManager manager = EntityConfig.getEntityManager();
	    String sql = "DELETE FROM Image i WHERE i.product.id=:prod_id";
	    Query query = manager.createQuery(sql);
	    query.setParameter("prod_id", id);

	    return query.executeUpdate() > 0;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }
}
