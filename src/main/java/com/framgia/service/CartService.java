package com.framgia.service;

import com.framgia.bean.CartInfo;
import com.framgia.bean.UserInfo;
public interface CartService extends BaseService<Integer, CartInfo> {

	CartInfo findByUserId(Integer id);

	CartInfo createNewCart(UserInfo userInfo);
}
