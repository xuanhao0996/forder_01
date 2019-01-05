package com.framgia.dao;

import java.util.List;

import com.framgia.model.Cart;
import com.framgia.model.User;

public interface CartDAO extends BaseDAO<Integer, Cart> {
	List<Cart> findByUserId(Integer userId);
	Cart createNewCart(User user);

}
