package com.jvideo.dao;

import java.util.List;

import com.jvideo.entity.User;
import com.jvideo.entity.Video;
import com.jvideo.util.JpaHelper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDAO {
	static EntityManager em = JpaHelper.getEntityManager();

	// them moi
	public static int create(User user) {
		em.getTransaction().begin();
		try {
			em.persist(user);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	// cập nhật
	public static int update(User user) {
		em.getTransaction().begin();
		try {
			em.merge(user);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	// xoa
	public static int delete(int id) {
		em.getTransaction().begin();
		try {
			User user = em.find(User.class, id);
			em.remove(user);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			return 0;
		}
		return 1;
	}

	// findAll
	public static List<User> findAll() {
		String jpql = "select v from User v";
		TypedQuery<User> query = em.createQuery(jpql, User.class);

		return query.getResultList();
	}

	// find by id
	public static User findById(int id) {
		return em.find(User.class, id);
	}
	
	//find by email
	public static User findByEmail(String email) {
		//String jpql = "select u from User u where u.email = :email";
		String jpql1 = "select u from User u where u.email = ?1";
		TypedQuery<User> query = em.createQuery(jpql1, User.class);
	//	query.setParameter("email", email);
		query.setParameter(1, email);
		return query.getSingleResult();
	}
	
	
}
