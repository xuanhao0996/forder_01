package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.framgia.entity.Cart;
import com.framgia.entity.CartDetail;
import com.framgia.model.CartDetailInfo;
import com.framgia.model.CartInfo;
import com.framgia.model.ProductInfo;

public class ConvertCart {
	public static List<CartInfo> convertListCartToListCartInfo(List<Cart> list) {

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

	public static CartInfo convertCartToCartInfo(Cart cart) {
		CartInfo cartInfo = new CartInfo();
		BeanUtils.copyProperties(cart, cartInfo);
		return cartInfo;
	}

	public static CartDetailInfo convertCartDetailToCartDetailInfo(CartDetail cartDetail) {
		CartDetailInfo cartDetailInfo = new CartDetailInfo();
		BeanUtils.copyProperties(cartDetail, cartDetailInfo);
		return cartDetailInfo;
	}

	public static Cart convertCartInfoToCart(CartInfo cartInfo) {
		Cart cart = new Cart();
		BeanUtils.copyProperties(cartInfo, cart);
		return cart;
	}

	public static List<CartDetailInfo> convertListCartDetailToListCartDetailInfo(
			List<CartDetail> findCartDetailByCartId) {

		List<CartDetailInfo> list = new ArrayList<CartDetailInfo>();
		for (CartDetail cartDetail : findCartDetailByCartId) {
			CartDetailInfo cartDetailInfo = new CartDetailInfo();
			BeanUtils.copyProperties(cartDetail, cartDetailInfo);

			if (cartDetail.getProduct() != null) {
				cartDetailInfo.setProduct(new ProductInfo(cartDetail.getProduct().getId()));
			}
			
			list.add(cartDetailInfo);
		}
		return list;

	}

	public static CartDetail cartDetailInfoToCartDetail(CartDetailInfo cartDetailInfo) {
		CartDetail cart = new CartDetail();
		BeanUtils.copyProperties(cartDetailInfo, cart);
		
		if (cartDetailInfo.getCart() != null) {
			cart.setCart(new Cart(cartDetailInfo.getCart().getId()));
		}
		return cart;
	}

}
