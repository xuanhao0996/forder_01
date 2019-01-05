package com.framgia.dao;

import java.util.List;

import com.framgia.model.Cart;
import com.framgia.model.CartDetail;
import com.framgia.model.Product;

public interface CartDetailDAO extends BaseDAO<Integer, CartDetail> {

	CartDetail createCartDetail(Cart cart, Product product);
	
	List<CartDetail> findByCartId(Integer id);	

}
