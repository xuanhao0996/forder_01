package com.framgia.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.framgia.service.CategoryService;
import com.framgia.bean.CategoryInfo;
import com.framgia.dao.CategoryDAO;
import com.framgia.model.Category;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public boolean create(CategoryInfo object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CategoryInfo object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CategoryInfo object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CategoryInfo findById(int categoryId) {
		try {
			return CategoryInfo.class.cast(categoryDAO.findById(categoryId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public List<CategoryInfo> getAll() {
		try {
			List<CategoryInfo> list = new ArrayList<CategoryInfo>();
			for(Object o: categoryDAO.getAll()) {
				list.add((CategoryInfo)o);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
	
}
