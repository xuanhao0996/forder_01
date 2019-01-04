package com.framgia.service;

import java.util.List;

import com.framgia.model.CategoryInfo;

public interface CategoryService extends BaseService<Integer, CategoryInfo> {
	
	public List<CategoryInfo> getCategories();
	
	public CategoryInfo getCategoryById(Integer id);
}
