package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.framgia.bean.CartDetailInfo;
import com.framgia.bean.CartInfo;
import com.framgia.bean.ProductInfo;
import com.framgia.hepler.ConvertCart;
import com.framgia.hepler.ConvertCartDetail;
import com.framgia.hepler.ConvertProduct;
import com.framgia.service.CartDetailService;

public class CartDetailServiceImpl extends BaseServiceImpl implements CartDetailService {

	private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);

	@Override
	public CartDetailInfo findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDetailInfo saveOrUpdate(CartDetailInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(CartDetailInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CartDetailInfo createCartDetailInfo(CartInfo cartInfo, ProductInfo productInfo) {
		try {
			return ConvertCartDetail.cartDetailToCartDetailInfo(cartDetailDAO.createCartDetail(
					ConvertCart.cartInfoToCart(cartInfo), ConvertProduct.productInfoToProduct(productInfo)));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<CartDetailInfo> findByCartInfoId(Integer id) {
		try {
			return ConvertCartDetail.listCartDetailToListCartDetailInfo(cartDetailDAO.findByCartId(id));
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
}
