package com.framgia.service.impl;

import com.framgia.dao.CategoryDAO;
import com.framgia.dao.ProductDAO;

public class BaseServiceImpl {

	protected ProductDAO productDAO;
	protected CategoryDAO categoryDAO;

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

}
