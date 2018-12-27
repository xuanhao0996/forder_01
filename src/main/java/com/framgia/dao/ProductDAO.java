package com.framgia.dao;

import java.util.List;

import com.framgia.model.Product;

public interface ProductDAO extends BaseDAO<Integer, Product>{
	
	public List<Product> getProducts(int start);

	public List<Product> getProductsByCategoryID(Integer id);
	
}
