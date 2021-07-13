package com.senlainc.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {
	
 	private static final EntityManagerFactory emFactory;
 	
	static {
		   emFactory = Persistence.createEntityManagerFactory("socialdbunit");
	}
	
	public static EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}
	
	public static void close(){
		emFactory.close();
	}
} 
