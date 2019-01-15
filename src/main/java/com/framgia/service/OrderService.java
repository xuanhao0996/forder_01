package com.framgia.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.framgia.bean.OrderInfo;
import com.framgia.model.Order;

public interface OrderService extends BaseService<Integer, Order> {
	OrderInfo createOrder(HttpSession httpSession);

	List<OrderInfo> getAll();

	Order findByIdJoinFetch(Integer id);

	boolean deleteOrder(Integer id);
}
