package com.framgia.service;

import java.util.List;

import com.framgia.model.Category;

public interface CategoryService extends BaseService<Integer, Category> {
	public List<Category> getCategories();
}
