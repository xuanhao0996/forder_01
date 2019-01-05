package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.framgia.bean.ProductInfo;
import com.framgia.hepler.ConvertProduct;
import com.framgia.service.ProductService;

public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
	
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Override
	public ProductInfo findById(Serializable key) {
		try {
			return ConvertProduct.productToProductInfo(productDAO.findById(key));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public ProductInfo saveOrUpdate(ProductInfo entity) {
		try {
			return ConvertProduct.productToProductInfo(productDAO.saveOrUpdate(ConvertProduct.productInfoToProduct(entity)));
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean delete(ProductInfo entity) {
		try {
			getProductDAO().delete(ConvertProduct.productInfoToProduct(entity));
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	@Override
	public ProductInfo findByName(String productName) {
		try {
			return ConvertProduct.productToProductInfo(productDAO.findByName(productName));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<ProductInfo> getAll() {
		try {
			return ConvertProduct.listProToProInfo(productDAO.getAll());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<ProductInfo> findByCategoryId(Integer id) {
		try {
			List<ProductInfo> list = ConvertProduct.listProToProInfo(productDAO.findByCategoryId(id));
			return list;

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
/*	@Override
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
*/
}
