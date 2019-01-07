package com.framgia.dao;

import java.io.Serializable;

import org.hibernate.LockMode;

public interface BaseDAO<PK, T> {
	
	boolean delete(T entity);

	T saveOrUpdate(T entity);

	T findById(Serializable key);
	
	T findByIdUsingLock(Serializable id, LockMode lockMode);
}
