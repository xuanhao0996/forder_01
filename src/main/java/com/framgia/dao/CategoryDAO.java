package com.framgia.dao;

import java.util.List;

import com.framgia.model.Category;

public interface CategoryDAO extends BaseDAO<Integer, Category> {
	
	public List<Category> getCategories();
}
