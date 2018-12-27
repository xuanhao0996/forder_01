package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import com.framgia.model.Category;
import com.framgia.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

	@Override
	public List<Category> getCategories() {

		return categoryDAO.getCategories();
	}

	@Override
	public Category findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category saveOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Category entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
