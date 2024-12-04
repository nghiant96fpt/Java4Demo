package com.fpoly.java4.dao;

import java.util.ArrayList;
import java.util.List;

import com.fpoly.java4.config.EntityConfig;
import com.fpoly.java4.models.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDAO {

    public static List<User> getAllUser() {
	try {
	    EntityManager manager = EntityConfig.getEntityManager();
	    String sql = "SELECT u FROM User u";
	    TypedQuery<User> query = manager.createQuery(sql, User.class);
	    return query.getResultList();

	} catch (Exception e) {

	    e.printStackTrace();
	    return new ArrayList<User>();
	}
    }

    public static User findByUsername(String username) {
	try {
	    EntityManager manager = EntityConfig.getEntityManager();
	    String sql = "SELECT u FROM User u WHERE username=:username";
	    TypedQuery<User> query = manager.createQuery(sql, User.class);
	    query.setParameter("username", username);

	    return query.getSingleResult();

	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }

    public static boolean insertUser(User user) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    manager.getTransaction().begin(); // Luu y
	    manager.persist(user);
	    manager.getTransaction().commit(); // Luu y
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    manager.getTransaction().rollback(); // Luu y
	    return false;
	}
    }

    public static boolean updateUser(User user) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    manager.getTransaction().begin(); // Luu y
	    manager.merge(user);
	    manager.getTransaction().commit(); // Luu y
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    manager.getTransaction().rollback(); // Luu y
	    return false;
	}
    }

    public static boolean deleteUser(String id) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    User user = manager.find(User.class, id);

	    manager.getTransaction().begin(); // Luu y
	    manager.remove(user);
	    manager.getTransaction().commit(); // Luu y
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    manager.getTransaction().rollback(); // Luu y
	    return false;
	}
    }

    public static User findById(String id) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    User user = manager.find(User.class, id);
	    return user;
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
}
