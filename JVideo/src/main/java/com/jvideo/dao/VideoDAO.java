package com.jvideo.dao;

import java.util.List;

import com.jvideo.entity.Video;
import com.jvideo.util.JpaHelper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class VideoDAO {
	static EntityManager em = JpaHelper.getEntityManager();
	//them moi
	public static int create(Video video) {
		em.getTransaction().begin();
		try {
			em.persist(video);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			return 0;
		}
		return 1;
	}
	//cập nhật
		public static int update(Video video) {
			em.getTransaction().begin();
			try {
				em.merge(video);
				em.getTransaction().commit();
				
			} catch (Exception e) {
				// TODO: handle exception
				em.getTransaction().rollback();
				return 0;
			}
			return 1;
		}
		//xoa
		public static int delete(int id) {
			em.getTransaction().begin();
			try {
				Video video = em.find(Video.class, id);
				em.remove(video);
				em.getTransaction().commit();
				
			} catch (Exception e) {
				// TODO: handle exception
				em.getTransaction().rollback();
				return 0;
			}
			return 1;
		}
	//select
	public static List<Video> findAll() {
		String jpql = "select v from Video v";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		
		return query.getResultList();
	}
	
	//find by id
	public static Video findById(int id) {
		return em.find(Video.class, id);
	}
}
