package com.framgia.service;

import java.util.List;

import com.framgia.model.Product;

public interface ProductService {
	
	public List<Product> getProducts();

	public List<Product> getProductsByCategoryID(Integer id);
}
