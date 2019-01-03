package com.framgia.service.impl;

import java.io.Serializable;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.framgia.bean.UserInfo;
import com.framgia.hepler.ConvertUser;
import com.framgia.model.User;
import com.framgia.service.UserService;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public User findById(Serializable key) {
		return null;
	}

	@Override
	public User saveOrUpdate(User entity) {
		return getUserDAO().saveOrUpdate(entity);
	}

	@Override
	public boolean delete(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo findByEmail(String email) {
		// TODO Auto-generated method stub
		return ConvertUser.convertSingleUserToUserInfo(getUserDAO().findByEmail(email));
	}

	@Override
	public UserInfo findByEmailAndPassword(String email, String password) {
		try {
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			boolean checkUser = passwordEncoder.matches(password,findByEmail(email).getPassword());
			if (!checkUser) {
				return null;
			}
			return ConvertUser.convertSingleUserToUserInfo(getUserDAO().findByEmail(email));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
