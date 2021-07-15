package com.senlainc.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("socialdbunit1");
	private static EntityManager entityManager;

	private EntityManagerUtility(){
		if (entityManager == null){
			entityManager = factory.createEntityManager();
		}
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}
} 
