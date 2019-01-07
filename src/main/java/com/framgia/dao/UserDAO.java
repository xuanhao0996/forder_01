package com.framgia.dao;

import java.util.List;

import com.framgia.bean.PaginationResult;
import com.framgia.model.User;

public interface UserDAO extends BaseDAO<Integer, User> {
	User findByEmail(String email);

	User findByEmailAndPassword(String email, String password);

	List<User> getAll();

	PaginationResult<User> queryProducts(int page, int maxResult, int maxNavigationPage);
}
