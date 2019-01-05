package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.framgia.bean.UserInfo;
import com.framgia.model.User;

public class ConvertUser {

	static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	static Function<User, UserInfo> userToUserInfo = (User user) -> {
		UserInfo info = new UserInfo();
		info.setId(user.getId());
		info.setName(user.getName());
		info.setEmail(user.getEmail());
		info.setPassword(user.getPassword());
		info.setPhone(user.getPhone());
		int role = user.getRole();
		if (role == 0) {
			info.setRole(ROLES.USER.toString());
		} else {
			info.setRole(ROLES.ADMIN.toString());
		}

		return info;
	};

	public static List<UserInfo> convertUserToUserInfo(List<User> arrUser) {
		List<UserInfo> arrUserInfo = new ArrayList<>();
		for (User u : arrUser) {
			arrUserInfo.add(userToUserInfo.apply(u));
		}
		return arrUserInfo;
	}

	public static UserInfo convertSingleUserToUserInfo(User user) {
		return userToUserInfo.apply(user);
	}

	static Function<UserInfo, User> userInfoToUser = (UserInfo userInfo) -> {
		User user = new User();

		user.setName(userInfo.getName());
		user.setEmail(userInfo.getEmail());
		user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		user.setPhone(userInfo.getPhone());
		user.setRole(1);
		if (ROLES.ADMIN.toString().equals(userInfo.getRole())) {
			user.setRole(0);
		}

		return user;
	};

	public static User convertSingleUserInfoToUser(UserInfo info) {
		return userInfoToUser.apply(info);
	}
}