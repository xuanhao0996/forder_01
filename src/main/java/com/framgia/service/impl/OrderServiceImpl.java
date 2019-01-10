package com.framgia.service.impl;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.framgia.bean.OrderInfo;
import com.framgia.bean.UserInfo;
import com.framgia.hepler.ConvertOrder;
import com.framgia.model.Order;
import com.framgia.service.OrderService;

public class OrderServiceImpl  extends BaseServiceImpl implements OrderService{

	@Override
	public Order findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order saveOrUpdate(Order entity) {
		try {
			return orderDAO.saveOrUpdate(entity);
		} catch (Exception e) {
			throw(e);
		}
	}

	@Override
	public boolean delete(Order entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderInfo createOrder(HttpSession httpSession) {
		OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date(System.currentTimeMillis()));
        orderInfo.setUser((UserInfo) httpSession.getAttribute("currentUser"));
        orderInfo.setTotalBill((float) httpSession.getAttribute("myCartTotal"));
        orderInfo.setStatus(0);
        return ConvertOrder.orderToInfo(saveOrUpdate(ConvertOrder.infoToOrder(orderInfo)));
	}

}
