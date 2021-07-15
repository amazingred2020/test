package com.senlainc.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("socialdbunit");
	private static EntityManager entityManager = factory.createEntityManager();;

	private EntityManagerUtility(){
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}
} 
