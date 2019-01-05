/*package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.framgia.hepler.ConvertProduct;
import com.framgia.model.ProductInfo;
import com.framgia.service.ProductService;

public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
	
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@Override
	public List<ProductInfo> getProducts(int start) {
		try {
			return ConvertProduct.convertListProductToProductInfo(productDAO.getProducts(start));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	@Override
	public List<ProductInfo> getProductsByCategoryID(Integer id) {

		try {
			List<ProductInfo> list = ConvertProduct.convertListProductToProductInfo(productDAO.getProductsByCategoryID(id));
			return list;

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public ProductInfo findById(Serializable key) {
		return null;
	}

	@Override
	public ProductInfo saveOrUpdate(ProductInfo entity) {
		return null;
	}

	@Override
	public boolean delete(ProductInfo entity) {
		return false;
	}

	@Override
	public ProductInfo getProductById(Integer id) {
		try{
			return (ProductInfo) ConvertProduct.convertProductToProductInfoVersionByBeanUtils(productDAO.getProductsById(id));
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
		
	}

}
*/