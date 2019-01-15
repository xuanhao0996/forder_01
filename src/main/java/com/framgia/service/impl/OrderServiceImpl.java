package com.framgia.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;

import com.framgia.bean.OrderInfo;
import com.framgia.bean.UserInfo;
import com.framgia.hepler.ConvertOrder;
import com.framgia.hepler.STATUS;
import com.framgia.model.Order;
import com.framgia.service.OrderService;

public class OrderServiceImpl  extends BaseServiceImpl implements OrderService{

	private static Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	@Override
	public Order findById(Serializable key) {
		try {
			return orderDAO.findById(key);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
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
		try {
			orderDAO.delete(entity);
			return true;
		} catch (Exception e) {
			throw(e);
		}
	}

	@Override
	public OrderInfo createOrder(HttpSession httpSession) {
		OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date(System.currentTimeMillis()));
        orderInfo.setUser((UserInfo) httpSession.getAttribute("currentUser"));
        orderInfo.setTotalBill((float) httpSession.getAttribute("myCartTotal"));
        orderInfo.setStatus(STATUS.WAITING.toString());
        return ConvertOrder.orderToInfo(saveOrUpdate(ConvertOrder.infoToOrder(orderInfo)));
	}

	@Override
	public List<OrderInfo> getAll() {
		try {
			return ConvertOrder.listOrderToListInfo(orderDAO.getAll());
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public Order findByIdJoinFetch(Integer id) {
		try {
			return orderDAO.findByIdjoinFetch(id);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteOrder(Integer id) {
		try {
			return delete(orderDAO.findByIdUsingLock(id, LockMode.PESSIMISTIC_WRITE));
		}catch (Exception e) {
			throw(e);
		}
	}

}
