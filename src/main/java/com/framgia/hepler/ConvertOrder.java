package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.framgia.bean.OrderInfo;
import com.framgia.model.Order;

public class ConvertOrder {
	public static OrderInfo orderToInfo(Order order) {
		OrderInfo info = new OrderInfo();
		BeanUtils.copyProperties(order, info);
		info.setUser(ConvertUser.userToUserInfo(order.getUser()));
		if(order.getStatus() == 0) {
			info.setStatus(STATUS.WAITING.toString());
		}else {
			info.setStatus(STATUS.ACCEPTED.toString());
		}
		return info;
	}
	
	public static Order infoToOrder(OrderInfo info) {
		Order order = new Order();
		BeanUtils.copyProperties(info, order);
		order.setUser(ConvertUser.userInfoToUser(info.getUser()));
		if (STATUS.WAITING.toString().equals(info.getStatus())) {
			order.setStatus(0);
		} else {
			order.setStatus(1);
		}
		return order;
	}
	
	public static List<Order> listInfoToOrders( List<OrderInfo> list) {
		List<Order> orders = new ArrayList<Order>();
		for (OrderInfo info : list) {
			Order order = infoToOrder(info);
			orders.add(order);
		}
		return orders;
	}
	
	public static List<OrderInfo> listOrderToListInfo(List<Order> list){
		List<OrderInfo> orderInfos = new ArrayList<>();
		for (Order order : list) {
			OrderInfo info = orderToInfo(order);
			orderInfos.add(info);
		}
		return orderInfos;
	}
}
