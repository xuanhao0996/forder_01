package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.framgia.bean.CartInfo;
import com.framgia.model.Cart;

public class ConvertCart {
	public static List<CartInfo> listCartToListCartInfo(List<Cart> list) {

		try {
			List<CartInfo> listCartInfo = new ArrayList<CartInfo>();
			for (Cart cart : list) {
				CartInfo categoryInfo = new CartInfo();
				BeanUtils.copyProperties(cart, categoryInfo);
				listCartInfo.add(categoryInfo);
			}
			return listCartInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static CartInfo cartToCartInfo(Cart cart) {
		CartInfo cartInfo = new CartInfo();
		BeanUtils.copyProperties(cart, cartInfo);
		return cartInfo;
	}

	public static Cart cartInfoToCart(CartInfo cartInfo) {
		Cart cart = new Cart();
		BeanUtils.copyProperties(cartInfo, cart);
		return cart;
	}

}