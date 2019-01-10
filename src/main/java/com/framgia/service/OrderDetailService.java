package com.framgia.service;


import javax.servlet.http.HttpSession;

import com.framgia.bean.OrderInfo;
import com.framgia.model.OrderDetail;

public interface OrderDetailService extends BaseService<Integer, OrderDetail>{
	void createOrderDetail(HttpSession httpSession, OrderInfo orderInfo);
}
