package com.framgia.dao;

import java.util.List;

import com.framgia.model.Product;

public interface ProductDAO extends BaseDAO<Integer, Product>{
    // find by name
	Product findByName(String categoryProduct);
 
    // load list category
    List<Product> getAll();

	List<Product> findByCategoryId(Integer id);
}
