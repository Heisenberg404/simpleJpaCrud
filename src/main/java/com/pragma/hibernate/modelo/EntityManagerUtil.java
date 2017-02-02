package com.pragma.hibernate.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static final EntityManagerFactory entityManagerFactory;

	static {
	try {
	entityManagerFactory = Persistence.createEntityManagerFactory("Persistencia");
	} catch (Throwable ex) {
	System.err.println("EntityManagerFactory creation failed." + ex);
	throw new ExceptionInInitializerError(ex);
	}
	}

	public static EntityManager getEntityManager() {
	EntityManager manager = null;
	try {
	manager = entityManagerFactory.createEntityManager();
	} catch (Throwable ex) {
	System.err.println("EntityManager creation failed." + ex);
	throw new IllegalStateException("EntityManager creation failed.", ex);
	}
	return manager;
	}

}
