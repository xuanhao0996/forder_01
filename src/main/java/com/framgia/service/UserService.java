package com.framgia.service;

import com.framgia.entity.User;
import com.framgia.model.UserInfo;

public interface UserService extends BaseService<Integer, User> {
	UserInfo findByEmailAndPassword(String email, String password);

	UserInfo findByEmail(String email);

}
