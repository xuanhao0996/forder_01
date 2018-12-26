package com.framgia.service.impl;

import java.util.List;

import com.framgia.model.Product;
import com.framgia.service.ProductService;

public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
	
	@Override
	public List<Product> getProducts() {
		try {
			return productDAO.getProducts();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
			
	}

	@Override
	public List<Product> getProductsByCategoryID(Integer id) {
		
		try {
			return productDAO.getProductsByCategoryID(id);
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
