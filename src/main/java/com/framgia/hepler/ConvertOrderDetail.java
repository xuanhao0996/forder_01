package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.framgia.bean.OrderDetailInfo;
import com.framgia.model.OrderDetail;

public class ConvertOrderDetail {
	public static OrderDetailInfo orderDetailToInfo(OrderDetail orderDetail) {
		OrderDetailInfo info = new OrderDetailInfo();
		BeanUtils.copyProperties(orderDetail, info);
		info.setOrder(ConvertOrder.orderToInfo(orderDetail.getOrder()));
		info.setProduct(ConvertProduct.productToProductInfo(orderDetail.getProduct()));
		return info;
	}
	
	public static OrderDetail infoToOrderDetail(OrderDetailInfo info) {
		OrderDetail orderDetail = new OrderDetail();
		BeanUtils.copyProperties(info, orderDetail);
		orderDetail.setOrder(ConvertOrder.infoToOrder(info.getOrder()));
		orderDetail.setProduct(ConvertProduct.productInfoToProduct(info.getProduct()));
		return orderDetail;
	}
	
	public static List<OrderDetail> listInfoToOrderDetails( List<OrderDetailInfo> list) {
		List<OrderDetail> list2 = new ArrayList<OrderDetail>();
		for (OrderDetailInfo info : list) {
			OrderDetail orderDetail = infoToOrderDetail(info);
			list2.add(orderDetail);
		}
		return list2;
	}
	
	public static List<OrderDetailInfo> listOrderDetailToListInfo(List<OrderDetail> list){
		List<OrderDetailInfo> infos = new ArrayList<OrderDetailInfo>();
		for (OrderDetail orderDetail : list) {
			OrderDetailInfo info = orderDetailToInfo(orderDetail);
			infos.add(info);
		}
		return infos;
	}
}
