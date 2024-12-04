package com.fpoly.java4.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//Instance class => Design pattern 
public class EntityConfig {
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
	if (entityManager == null) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("FPolyDemo");
	    entityManager = factory.createEntityManager();

	    System.out.println("Khoi tao");
	}

	return entityManager;
    }
}
