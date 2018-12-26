package com.framgia.service;

import java.util.List;

import com.framgia.bean.ProductInfo;
import com.framgia.model.Product;

public interface ProductService extends BaseService<Integer, ProductInfo> {
	
	public List<ProductInfo> getProducts(int start);

	public List<Product> getProductsByCategoryID(Integer id);
}
