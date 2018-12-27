package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import com.framgia.bean.CategoryInfo;
import com.framgia.hepler.ConvertCategory;
import com.framgia.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

	@Override
	public List<CategoryInfo> getCategories() {
		try {
			return ConvertCategory.convertListCategoryToListCategoryInfo(categoryDAO.getCategories());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryInfo findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryInfo saveOrUpdate(CategoryInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(CategoryInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CategoryInfo getCategoryById(Integer id) {
		try {
			return ConvertCategory.convertCategoryToCategoryInfo(categoryDAO.getCategoryByID(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
