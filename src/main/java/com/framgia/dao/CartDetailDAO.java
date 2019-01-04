package com.framgia.dao;

import java.io.Serializable;
import java.util.List;

import com.framgia.model.CartDetail;

public interface CartDetailDAO {
	CartDetail findById(Serializable key, boolean isLock);

	void saveOrUpdate(CartDetail cartDetail);

	List<CartDetail> findCartDetailsByUserId(Integer id);
}
