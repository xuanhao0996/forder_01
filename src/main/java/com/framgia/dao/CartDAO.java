package com.framgia.dao;

import java.util.List;

import com.framgia.entity.Cart;
import com.framgia.entity.CartDetail;
import com.framgia.entity.Product;
import com.framgia.entity.User;

public interface CartDAO extends BaseDAO<Integer, Cart> {
	Cart getCartByUserId(Integer id);

	Cart createCart(User user);

	CartDetail createCartDetail(Cart cart, Integer productId);

	List<CartDetail> findCartDetailByCartId(Integer id);

	Product getProductByCartDetailId(Integer id);

	void saveOrUpdateCartDetail(CartDetail cartDetail);

}
