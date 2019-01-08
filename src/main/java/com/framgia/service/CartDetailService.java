package com.framgia.service;

import java.util.List;

import com.framgia.bean.CartDetailInfo;
import com.framgia.bean.CartInfo;
import com.framgia.bean.ProductInfo;

public interface CartDetailService extends BaseService<Integer, CartDetailInfo> {
	
	CartDetailInfo createCartDetailInfo(CartInfo cartInfo, ProductInfo productInfo);
	
	List<CartDetailInfo> findByCartInfoId(Integer id);
}
