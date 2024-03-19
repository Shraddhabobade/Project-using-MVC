package com.tka.DemoMVC1.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.DemoMVC1.entity.User1;

@Repository
public class User1Dao {


	@Autowired
	SessionFactory factory;

	public User1 checkUser(User1 user) {
		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from  User1 where username=:username and password=:password";
		User1 u = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<User1> query = session.createQuery(hqlQuery, User1.class);
			query.setParameter("username", user.getUsername());
			query.setParameter("password", user.getPassword());
			u = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}

		}

		return u;

	}
}
