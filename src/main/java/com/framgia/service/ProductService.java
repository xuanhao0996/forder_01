package com.framgia.service;

import java.util.List;

import com.framgia.bean.ProductInfo;

public interface ProductService extends BaseService<Integer, ProductInfo> {
	
    // find by name
	ProductInfo findByName(String productName);
 
    // load list category
    List<ProductInfo> getAll();
}
