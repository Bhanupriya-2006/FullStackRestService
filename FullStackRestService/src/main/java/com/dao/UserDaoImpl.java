package com.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;


@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User createUser(User user) 
	{
		Session session=this.sessionFactory.openSession();
		session.save(user);
		return user;
	}

	@Override
	public List<User> readUser() 
	{
		Session session=this.sessionFactory.openSession();
		String readUser="from User";
		List<User> users=session.createQuery(readUser).list();
		
		
		return users;
	}

	public User readUserById(int userId) {
		Session session = this.sessionFactory.openSession();
		/*String hqlRead="FROM User U WHERE U.userId = 1";
		List<User> users = session.createQuery(hqlRead).list();*/

		String hqlRead = "from User U WHERE U.userId = :userId";
		List<User> users = session.createQuery(hqlRead).setParameter("userId", userId).list();

		return users.get(0);
		}

	@Override
	public User readUserByName(String name) {
		
		return null;
	}

	@Override
	public User updateUser(User user) 
	{

		Session session = this.sessionFactory.openSession();
		session.saveOrUpdate(user);
		return user;
		
		
		
	}
		

	@Override
	public User deleteUserById(int userId) {
		
		Session session = this.sessionFactory.openSession();
		User obj=session.load(User.class, userId);
		Transaction tx=session.beginTransaction();
		session.delete(obj);
		tx.commit();
		return obj;
		}
	}


