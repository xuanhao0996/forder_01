package com.framgia.dao;


import com.framgia.model.User;

public interface UserDAO extends BaseDAO<Integer, User>{
	 User findByEmail(String email);
	 
	 User findByEmailAndPassword(String email,String password);
}
