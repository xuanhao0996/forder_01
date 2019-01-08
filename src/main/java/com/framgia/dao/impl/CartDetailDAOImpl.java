package com.framgia.dao.impl;

import java.io.Serializable;
import java.util.List;
import com.framgia.dao.CartDetailDAO;
import com.framgia.dao.GenericDAO;
import com.framgia.model.Cart;
import com.framgia.model.CartDetail;
import com.framgia.model.Product;


public class CartDetailDAOImpl extends GenericDAO<Integer, CartDetail> implements CartDetailDAO {

	@Override
	public boolean delete(CartDetail entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CartDetail saveOrUpdate(CartDetail entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDetail findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDetail createCartDetail(Cart cart, Product product) {
		CartDetail cartDetail = new CartDetail();
		cartDetail.setCart(cart);
		cartDetail.setProduct(product);
		getSession().saveOrUpdate(cartDetail);
		return cartDetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartDetail> findByCartId(Integer id) {
		return getSession().createQuery("select cd from CartDetail cd "
										+ "where cd.cart.id = :id")
										.setParameter("id", id)
										.getResultList();
	}
}
