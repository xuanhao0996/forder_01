package com.framgia.dao;

import java.util.List;

import com.framgia.entity.Product;

public interface ProductDAO extends BaseDAO<Integer, Product>{
	//get all product
	public List<Product> getProducts();
	
	//get products by id
	public Product getProductsById(Integer id);
	
	//get list product by category id
	public List<Product> getProductsByCategoryID(Integer id);

	List<Product> getProducts(int start);
	
}
