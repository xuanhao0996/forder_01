package com.framgia.service.impl;

import java.util.List;

import com.framgia.model.Category;
import com.framgia.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

	@Override
	public List<Category> getCategories() {

		return categoryDAO.getCategories();
	}

}
