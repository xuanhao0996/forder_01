package com.framgia.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.framgia.bean.CartDetailInfo;
import com.framgia.bean.OrderDetailInfo;
import com.framgia.bean.OrderInfo;
import com.framgia.hepler.ConvertOrderDetail;
import com.framgia.model.OrderDetail;
import com.framgia.service.OrderDetailService;

public class OrderDetailServiceImpl extends BaseServiceImpl implements OrderDetailService {

	@Override
	public OrderDetail findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail saveOrUpdate(OrderDetail entity) {
		try {
			return orderDetailDAO.saveOrUpdate(entity);
		} catch (Exception e) {
			throw(e);
		}
	}

	@Override
	public boolean delete(OrderDetail entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createOrderDetail(HttpSession httpSession, OrderInfo orderInfo) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDetailInfo> cartItems = (HashMap<Integer, CartDetailInfo>) httpSession.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        //set parameter of orderDetail
        for(Map.Entry<Integer, CartDetailInfo> entry : cartItems.entrySet()){
        	OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
        	orderDetailInfo.setOrder(orderInfo);
        	orderDetailInfo.setProduct(entry.getValue().getProduct());
        	orderDetailInfo.setProductPrice(entry.getValue().getProduct().getPrice());
        	orderDetailInfo.setQuantity(entry.getValue().getQuantity());
        	saveOrUpdate(ConvertOrderDetail.infoToOrderDetail(orderDetailInfo));
        }
        
        cartItems = new HashMap<>();
        httpSession.setAttribute("myCartItems", cartItems);
        httpSession.setAttribute("myCartTotal", 0);
        httpSession.setAttribute("myCartNum", 0);
	}

}
