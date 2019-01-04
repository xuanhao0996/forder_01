package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.framgia.bean.CategoryInfo;
import com.framgia.hepler.ConvertCategory;
import com.framgia.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

	private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);
	
	@Override
	public CategoryInfo findByName(String categoryName) {
		try {
			return ConvertCategory.categoryToCategoryInfo(categoryDAO.findByName(categoryName));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<CategoryInfo> getAll() {
		try {
			return ConvertCategory.listCategoryToCategoryInfo(categoryDAO.getAll());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public CategoryInfo findById(Serializable key) {
		try {
			return ConvertCategory.categoryToCategoryInfo(categoryDAO.findById(key));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public CategoryInfo saveOrUpdate(CategoryInfo entity) {
		try {
			return ConvertCategory.
					categoryToCategoryInfo(categoryDAO.saveOrUpdate(ConvertCategory
							.categoryInfoToCategory(entity)));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean delete(CategoryInfo entity) {
		try {
			getCategoryDAO().delete(ConvertCategory.categoryInfoToCategory(entity));
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
