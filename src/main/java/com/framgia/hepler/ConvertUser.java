package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.framgia.bean.UserInfo;
import com.framgia.model.User;

public class ConvertUser {
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
}
