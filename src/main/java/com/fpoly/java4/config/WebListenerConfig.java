package com.fpoly.java4.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import jakarta.persistence.EntityManager;

@WebListener
public class WebListenerConfig implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
	// TODO Auto-generated method stub

	// Duoc kich hoat khi ung dung dong lai

	System.out.println("Application stop");

	// Ngat ket noi database
	EntityManager manager = EntityConfig.getEntityManager();
	manager.close();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
	// TODO Auto-generated method stub

	// Duoc kich hoat khi ung dung khoi tao

	System.out.println("Application start");

	// Khoi tao ket noi database
	EntityConfig.getEntityManager();
    }

}
