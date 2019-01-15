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
		return info;
	}
	
	public static Order infoToOrder(OrderInfo info) {
		Order order = new Order();
		BeanUtils.copyProperties(info, order);
		order.setUser(ConvertUser.userInfoToUser(info.getUser()));
		return order;
	}
	
	public static List<Order> listInfoToOrders( List<OrderInfo> list) {
		List<Order> list2 = new ArrayList<Order>();
		for (OrderInfo info : list) {
			Order order = infoToOrder(info);
			list2.add(order);
		}
		return list2;
	}
	
	public static List<OrderInfo> listOrderToListInfo(List<Order> list){
		List<OrderInfo> infos = new ArrayList<>();
		for (Order order : list) {
			OrderInfo info = orderToInfo(order);
			infos.add(info);
		}
		return infos;
	}
}
