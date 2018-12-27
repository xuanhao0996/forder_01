package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.framgia.bean.CategoryInfo;
import com.framgia.model.Category;

public class ConvertCategory {

	public static List<CategoryInfo> convertListCategoryToListCategoryInfo(List<Category> list) {
		
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

	public static CategoryInfo convertCategoryToCategoryInfo(Category category) {
		CategoryInfo categoryInfo = new CategoryInfo();
		BeanUtils.copyProperties(category, categoryInfo);
		return categoryInfo;
	}
	
	
}
