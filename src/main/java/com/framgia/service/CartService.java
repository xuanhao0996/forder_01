package com.framgia.service;
import java.util.List;

import com.framgia.bean.CartInfo;
import com.framgia.bean.UserInfo;
public interface CartService extends BaseService<Integer, CartInfo> {
	List<CartInfo> findByUserId(Integer id);
	CartInfo createNewCart(UserInfo userInfo);
}
