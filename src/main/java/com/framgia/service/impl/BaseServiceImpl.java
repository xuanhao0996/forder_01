package com.framgia.service.impl;

import com.framgia.dao.CategoryDAO;
import com.framgia.dao.OrderDAO;
import com.framgia.dao.OrderDetailDAO;
import com.framgia.dao.ProductDAO;
import com.framgia.dao.UserDAO;

public class BaseServiceImpl {

	protected ProductDAO productDAO;
	protected CategoryDAO categoryDAO;
	protected UserDAO userDAO;
	protected OrderDAO orderDAO;
	protected OrderDetailDAO orderDetailDAO;
	
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

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public OrderDetailDAO getOrderDetailDAO() {
		return orderDetailDAO;
	}

	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}
	
}
