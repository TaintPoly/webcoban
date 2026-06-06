package com.jvideo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaHelper {
	//bước 1
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JVideo");
	//B2:
	public static EntityManager getEntityManager() {
		return  factory.createEntityManager();
	}

}
