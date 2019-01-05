package com.framgia.dao.impl;

import java.io.Serializable;
import com.framgia.dao.CartDAO;
import com.framgia.dao.GenericDAO;
import com.framgia.model.Cart;
import com.framgia.model.User;

public class CartDAOImpl extends GenericDAO<Integer, Cart> implements CartDAO {

	@Override
	public boolean delete(Cart entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cart saveOrUpdate(Cart entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public Cart findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart findByUserId(Integer userId) {
		return (Cart) getSession().createQuery("SELECT c FROM Cart "
										+ "WHERE c.user.id = :userId "
										+ "AND c.status = 0")
										.setParameter("userId", userId)
										.getSingleResult();
	}

	@Override
	public Cart createNewCart(User user) {
		Cart newCart = new Cart();
		newCart.setUser(user);
		newCart.setStatus(0);
		getSession().saveOrUpdate(newCart);
		return newCart;
	}

}