package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.framgia.bean.CategoryInfo;
import com.framgia.model.Category;

public class ConvertCategory {

	public static List<CategoryInfo> listCategoryToCategoryInfo(List<Category> list) {
		try {
			List<CategoryInfo> listCategoryInfo = new ArrayList<CategoryInfo>();
			
			for (Category category : list) {
				CategoryInfo categoryInfo = new CategoryInfo();
				BeanUtils.copyProperties(category, categoryInfo);
				listCategoryInfo.add(categoryInfo);
			}
			return listCategoryInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static CategoryInfo categoryToCategoryInfo(Category category) {
		CategoryInfo categoryInfo = new CategoryInfo();
		BeanUtils.copyProperties(category, categoryInfo);
		return categoryInfo;
	}
	
	public static Category categoryInfoToCategory(CategoryInfo categoryInfo) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryInfo, category);
		return category;
	}
	
}