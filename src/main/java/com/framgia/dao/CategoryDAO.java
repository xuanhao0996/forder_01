package com.framgia.dao;

import java.util.List;

import com.framgia.entity.Category;

public interface CategoryDAO extends BaseDAO<Integer, Category> {
	
    // create
    public boolean create(Category object);
 
    // update
    public boolean update(Category object);
 
    // delete
    public boolean delete(Category object);
 
    // find by id
    public Category findById(int categoryId);
	
	public List<Category> getCategories();

	public Category getCategoryByID(Integer id);
}
