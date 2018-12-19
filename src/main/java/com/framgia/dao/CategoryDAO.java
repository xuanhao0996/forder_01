package com.framgia.dao;

import java.util.List;

import com.framgia.model.Category;

public interface CategoryDAO {
	
	// create
    public boolean create(Category object);
 
    // update
    public boolean update(Category object);
    		
    // delete
    public boolean delete(Category object);
 
    // find by id
    public Category findById(int categoryId);
 
    // load list category
    public List<Category> getAll();
}
