package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.framgia.bean.UserInfo;
import com.framgia.model.User;

public class ConvertUser {

	static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public static UserInfo userToUserInfo(User user) {
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(user, userInfo);
		if (user.getRole() == 0) {
			userInfo.setRole(ROLES.ADMIN.toString());
		} else {
			userInfo.setRole(ROLES.USER.toString());
		}
		return userInfo;
	}

	public static User userInfoToUser(UserInfo userInfo) {
		User user = new User();
		BeanUtils.copyProperties(userInfo, user);
		user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		if (ROLES.ADMIN.toString().equals(userInfo.getRole())) {
			user.setRole(0);
		} else {
			user.setRole(1);
		}
		return user;
	}

	public static List<User> userInfosToUsers(List<UserInfo> userInfos){
		List<User> users = new ArrayList<>();
		for(UserInfo userInfo:userInfos) {
			User user = new User();
			user = ConvertUser.userInfoToUser(userInfo);
			users.add(user);
		}
		return users;
	}
	public static List<UserInfo> usersToUserInfos(List<User> users){
		List<UserInfo> userInfos = new ArrayList<>();
		for(User user:users) {
			UserInfo userInfo = new UserInfo();
			userInfo = ConvertUser.userToUserInfo(user);
			userInfos.add(userInfo);
		}
		return userInfos;
	}
}