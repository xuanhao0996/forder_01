package com.framgia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockMode;

import com.framgia.dao.GenericDAO;
import com.framgia.dao.UserDAO;
import com.framgia.model.User;

public class UserDAOImpl extends GenericDAO<Integer, User> implements UserDAO {

	@Override
	public User findByEmail(String email) {
		logger.info("email: " + email);
		return getSession().createQuery("from User user where email = :email", User.class)
				.setParameter("email", email)
				.uniqueResult();
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		logger.info("email: " + email);
		return getSession().createQuery("from User user where email = :email and password = :password", User.class)
				.setParameter("email", email).setParameter("password", password)
				.getSingleResult();
	}

	@Override
	public List<User> getAll() {
		return getSession().createQuery("from User", User.class).getResultList();
	}

	@Override
	public User findByIdUsingLock(Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

}