package com.framgia.service;

import java.util.List;

import com.framgia.model.CartDetailInfo;
import com.framgia.model.CartInfo;
import com.framgia.model.ProductInfo;
import com.framgia.model.UserInfo;

public interface CartService extends BaseService<Integer, CartInfo> {

	public CartInfo getCartByUserId(Integer id);

	public CartInfo createCart(UserInfo userInfo, int productId);
	
	public CartDetailInfo createCartDetail(CartInfo cartInfo, Integer productId);

	public List<CartDetailInfo> findCartDetailByCartId(Integer id);

	public ProductInfo getProductByCartDetailId(Integer id);

	public void saveOrUpdateCartDetail(CartDetailInfo cartDetailInfo);

}
