package com.framgia.dao;

import java.util.List;

import com.framgia.model.Product;

public interface ProductDAO {
	
	public List<Product> getProducts();

	public List<Product> getProductsByCategoryID(Integer id);
	
}
