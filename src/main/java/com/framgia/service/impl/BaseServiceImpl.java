package com.framgia.service.impl;

import com.framgia.dao.CartDAO;
import com.framgia.dao.CartDetailDAO;
import com.framgia.dao.CategoryDAO;
import com.framgia.dao.ProductDAO;
import com.framgia.dao.UserDAO;

public class BaseServiceImpl {

	protected ProductDAO productDAO;
	protected CategoryDAO categoryDAO;
	protected UserDAO userDAO;
	protected CartDAO cartDAO;
	protected CartDetailDAO cartDetailDAO;

	public CartDetailDAO getCartDetailDAO() {
		return cartDetailDAO;
	}

	public void setCartDetailDAO(CartDetailDAO cartDetailDAO) {
		this.cartDetailDAO = cartDetailDAO;
	}

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

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public CartDAO getCartDAO() {
		return cartDAO;
	}

	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

}
