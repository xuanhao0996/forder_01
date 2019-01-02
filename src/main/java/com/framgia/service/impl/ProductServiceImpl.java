package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import com.framgia.bean.ProductInfo;
import com.framgia.hepler.ConvertProduct;
import com.framgia.service.ProductService;

public class ProductServiceImpl extends BaseServiceImpl implements ProductService {

	@Override
	public List<ProductInfo> getProducts(int start) {
		try {
			return ConvertProduct.convertListProductToProductInfo(productDAO.getProducts(start));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public List<ProductInfo> getProductsByCategoryID(Integer id) {

		try {
			List<ProductInfo> list = ConvertProduct.convertListProductToProductInfo(productDAO.getProductsByCategoryID(id));
			return list;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ProductInfo findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductInfo saveOrUpdate(ProductInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ProductInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
