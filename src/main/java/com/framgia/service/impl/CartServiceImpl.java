package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.framgia.bean.CartInfo;
import com.framgia.bean.UserInfo;
import com.framgia.hepler.ConvertCart;
import com.framgia.hepler.ConvertUser;
import com.framgia.service.CartService;

public class CartServiceImpl extends BaseServiceImpl implements CartService {
	private static Logger logger = Logger.getLogger(CartServiceImpl.class);

	@Override
	public CartInfo findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartInfo saveOrUpdate(CartInfo entity) {
		try {
			return ConvertCart.cartToCartInfo(getCartDAO()
					.saveOrUpdate(ConvertCart.cartInfoToCart(entity)));
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean delete(CartInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CartInfo> findByUserId(Integer userId) {
		try {
			return ConvertCart.listCartToListCartInfo(cartDAO.findByUserId(userId));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public CartInfo createNewCart(UserInfo userInfo) {
		try {
			return ConvertCart.cartToCartInfo(cartDAO.
								createNewCart(ConvertUser
										.convertSingleUserInfoToUser(userInfo)));
		}catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

}
