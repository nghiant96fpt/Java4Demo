package com.fpoly.java4.dao;

import java.util.ArrayList;
import java.util.List;

import com.fpoly.java4.config.EntityConfig;
import com.fpoly.java4.models.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AddressesDAO {

    public static List<Address> findByUserId(String userId) {
	try {
	    EntityManager manager = EntityConfig.getEntityManager();

	    String sql = "SELECT a FROM Address a WHERE a.user.userId=:userId";

	    TypedQuery<Address> query = manager.createQuery(sql, Address.class);
	    query.setParameter("userId", userId);

	    return query.getResultList();

	} catch (Exception e) {
	    return new ArrayList<Address>();
	}
    }

    public static boolean insertAddress(Address address) {
	EntityManager manager = EntityConfig.getEntityManager();
	try {
	    manager.getTransaction().begin();
	    manager.persist(address);
	    manager.getTransaction().commit();
	    return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    manager.getTransaction().rollback();
	    return false;
	}
    }
//
//    public static boolean updateAddress(Address address) {
//
//    }
//
//    public static boolean deleteAddress(Address address) {
//
//    }
//
//    public static Address findById(String id) {
//
//    }

}
