/*package com.framgia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Restrictions;

import com.framgia.bean.CartDetailInfo;
import com.framgia.dao.CartDetailDAO;
import com.framgia.dao.GenericDAO;
import com.framgia.model.CartDetail;


public class CartDetailDAOImpl extends GenericDAO<Integer, CartDetail> implements CartDetailDAO {

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

	@Override
	public boolean delete(CartDetailInfo entity) {
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


}*/