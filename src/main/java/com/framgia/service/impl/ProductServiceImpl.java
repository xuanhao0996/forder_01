package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;

import com.framgia.bean.ProductInfo;
import com.framgia.hepler.ConvertDateSql;
import com.framgia.hepler.ConvertProduct;
import com.framgia.model.Category;
import com.framgia.model.Product;
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
			if(entity.getId() != null) {
				Product updateProduct = new Product();
				
				updateProduct.setId(entity.getId());
				updateProduct.setName(entity.getName());
				Category category = new  Category();
				category.setId(entity.getCategory());
				updateProduct.setCategory(category);
				updateProduct.setPrice(entity.getPrice());
				updateProduct.setImage(entity.getImage());
				updateProduct.setCode(entity.getCode());
				updateProduct.setDesciption(entity.getDesciption());
				updateProduct.setExpiryDate(ConvertDateSql.convertDateToSave(entity.getExpiryDate()));
				return ConvertProduct.productToProductInfo(productDAO.saveOrUpdate(updateProduct));
			}
			return ConvertProduct.productToProductInfo(productDAO.saveOrUpdate(ConvertProduct.ConvertproductInfoToProductToSave(entity)));
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean delete(ProductInfo entity) {
		Product deleteProduct = getProductDAO().findByIdUsingLock(entity.getId(), LockMode.PESSIMISTIC_WRITE);
		try {
			if(deleteProduct == null) {
				return false;
			}
			getProductDAO().delete(deleteProduct);
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
