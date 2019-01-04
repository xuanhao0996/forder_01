package com.framgia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Restrictions;

import com.framgia.dao.CartDetailDAO;
import com.framgia.dao.GenericDAO;
import com.framgia.entity.Cart;
import com.framgia.entity.CartDetail;

public class CartDetailDAOImpl extends GenericDAO<Integer, Cart> implements CartDetailDAO {

	@Override
	public CartDetail findById(Serializable key, boolean isLock) {
		@SuppressWarnings("deprecation")
		Criteria criteria = getSession().createCriteria(CartDetail.class);
		if (isLock)
			criteria.setLockMode(LockMode.PESSIMISTIC_WRITE);
		return (CartDetail) criteria.add(Restrictions.eq("id", key)).uniqueResult();
	}

	@Override
	public void saveOrUpdate(CartDetail cartDetail) {
		getSession().saveOrUpdate(cartDetail);
	}

	@Override
	public List<CartDetail> findCartDetailsByUserId(Integer id) {
		return getSession().createQuery("SELECT cd FROM CartDetail "
										+ "inner join Cart c on cd.cart.id = c.id "
										+ "inner join User u on c.user.id = u.id "
										+ "WHERE u.id = :id", CartDetail.class).setParameter("id", id).getResultList();
	}

}
