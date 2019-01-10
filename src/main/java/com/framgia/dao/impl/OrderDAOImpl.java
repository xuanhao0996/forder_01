package com.framgia.dao.impl;
import java.util.List;
import com.framgia.dao.GenericDAO;
import com.framgia.dao.OrderDAO;
import com.framgia.model.Order;

public class OrderDAOImpl extends GenericDAO<Integer, Order> implements OrderDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAll() {
		return getSession().createQuery("from Order").getResultList();
	}

	@Override
	public Order findByIdjoinFetch(Integer id) {
		return (Order) getSession().createQuery("SELECT o FROM Order o JOIN FETCH o.user"
												+ " where o.id = :id").setParameter("id", id).getSingleResult();
	}

}
