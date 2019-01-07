package com.framgia.service;

import com.framgia.bean.UserInfo;
import com.framgia.model.User;

import java.util.List;

public interface UserService extends BaseService<Integer, User> {
	
	boolean deleteUser(Integer id);
	
	UserInfo findByEmailAndPassword(String email, String password);

	UserInfo findByEmail(String email);

	List<User> getAll();
}
