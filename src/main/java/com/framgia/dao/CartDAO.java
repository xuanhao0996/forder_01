package com.framgia.dao;

import com.framgia.model.Cart;
import com.framgia.model.User;

public interface CartDAO extends BaseDAO<Integer, Cart> {
	Cart findByUserId(Integer userId);

	Cart createNewCart(User user);

}
