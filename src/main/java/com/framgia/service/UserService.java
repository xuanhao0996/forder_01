package com.framgia.service;

import com.framgia.bean.UserInfo;
import com.framgia.model.User;

public interface UserService extends BaseService<Integer, User> {
	UserInfo findByEmailAndPassword(String email, String password);

	UserInfo findByEmail(String email);

}
