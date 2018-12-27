package com.framgia.service;

import java.util.List;
import com.framgia.bean.ProductInfo;

public interface ProductService extends BaseService<Integer, ProductInfo> {
	
	public List<ProductInfo> getProducts(int start);

	public List<ProductInfo> getProductsByCategoryID(Integer id);
}
