package com.framgia.dao;

import java.util.List;

import com.framgia.model.Cart;
import com.framgia.model.CartDetail;
import com.framgia.model.Product;
import com.framgia.model.User;

public interface CartDAO extends BaseDAO<Integer, Cart> {
	Cart getCartByUserId(Integer id);

	Cart createCart(User user);

	CartDetail createCartDetail(Cart cart, Integer productId);

	List<CartDetail> findCartDetailByCartId(Integer id);

	Product getProductByCartDetailId(Integer id);

	void saveOrUpdateCartDetail(CartDetail cartDetail);

}
