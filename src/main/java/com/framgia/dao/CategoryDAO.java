package com.framgia.dao;

import java.util.List;

import com.framgia.model.Category;

public interface CategoryDAO extends BaseDAO<Integer, Category> {
	
    // find by name
    Category findByName(String categoryName);
 
    // load list category
    List<Category> getAll();
	
}
