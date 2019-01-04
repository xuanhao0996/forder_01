package com.framgia.service;

import java.util.List;

import com.framgia.bean.CategoryInfo;

public interface CategoryService extends BaseService<Integer, CategoryInfo> {
    // find by name
	CategoryInfo findByName(String categoryName);
 
    // load list category
    List<CategoryInfo> getAll();
}
