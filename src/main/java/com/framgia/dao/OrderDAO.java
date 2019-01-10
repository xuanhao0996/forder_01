package com.framgia.dao;
import java.util.List;

import com.framgia.model.Order;

public interface OrderDAO extends BaseDAO<Integer, Order> {
	List<Order> getAll();

	Order findByIdjoinFetch(Integer id);
}
