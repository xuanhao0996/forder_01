package com.framgia.dao.impl;

import java.util.List;

import org.hibernate.query.Query;

import com.framgia.bean.PaginationResult;
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
	public PaginationResult<User> queryProducts(int page, int maxResult, int maxNavigationPage) {
		@SuppressWarnings("rawtypes")
		Query query = getSession().createQuery("from User order by id");
		  return new PaginationResult<User>(query, page, maxResult, maxNavigationPage);
	}
}