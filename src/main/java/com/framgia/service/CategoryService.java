package com.framgia.service;

import java.util.List;

import com.framgia.bean.CategoryInfo;

public interface CategoryService extends BaseService<Integer, CategoryInfo>{
	// create
    public boolean create(CategoryInfo object);
 
    // update
    public boolean update(CategoryInfo object);
 
    // delete
    public boolean delete(CategoryInfo object);
 
    // find by id
    public CategoryInfo findById(int categoryId);
 
    // load list category
    public List<CategoryInfo> getAll();
}
