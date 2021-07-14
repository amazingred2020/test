package com.senlainc.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerUtility {

	public static EntityManager getEntityManager(){
		return Persistence.createEntityManagerFactory("socialdbunit2").createEntityManager();
	}
} 
