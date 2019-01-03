package com.framgia.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.framgia.entity.Cart;
import com.framgia.entity.CartDetail;
import com.framgia.entity.Product;
import com.framgia.hepler.ConvertCart;
import com.framgia.hepler.ConvertProduct;
import com.framgia.hepler.ConvertUser;
import com.framgia.model.CartDetailInfo;
import com.framgia.model.CartInfo;
import com.framgia.model.ProductInfo;
import com.framgia.model.UserInfo;
import com.framgia.service.CartService;

public class CartServiceImpl extends BaseServiceImpl implements CartService {
	private static Logger logger = Logger.getLogger(CartServiceImpl.class);

	@Override
	public CartInfo getCartByUserId(Integer id) {
		try {
			return ConvertCart.convertCartToCartInfo(cartDAO.getCartByUserId(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public CartInfo findById(Serializable key) {
		return null;
	}

	@Override
	public CartInfo saveOrUpdate(CartInfo entity) {
		return null;
	}

	@Override
	public boolean delete(CartInfo entity) {
		return false;
	}

	@Override
	public CartInfo createCart(UserInfo userInfo, int productId) {
		try {

			// insert cart
			Cart cart = cartDAO.createCart(ConvertUser.convertSingleUserInfoToUser(userInfo));

			// insert cartDetail
			CartDetail cartDetail = new CartDetail();
			cartDetail.setProduct(new Product(productId));
			cartDetailDAO.saveOrUpdate(cartDetail);

			return ConvertCart.convertCartToCartInfo(cart);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public CartDetailInfo createCartDetail(CartInfo cartInfo, Integer productId) {
		try {
			return ConvertCart.convertCartDetailToCartDetailInfo(
					cartDAO.createCartDetail(ConvertCart.convertCartInfoToCart(cartInfo), productId));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<CartDetailInfo> findCartDetailByCartId(Integer id) {
		try {
			return ConvertCart.convertListCartDetailToListCartDetailInfo(cartDAO.findCartDetailByCartId(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProductInfo getProductByCartDetailId(Integer id) {
		try {
			return ConvertProduct.convertProductToProductInfoVersionByBeanUtils(cartDAO.getProductByCartDetailId(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@Override
	public void saveOrUpdateCartDetail(CartDetailInfo cartDetailInfo) {
		try {
			CartDetail cartDetail = new CartDetail(new Cart(cartDetailInfo.getCart().getId()),
					new Product(cartDetailInfo.getProduct().getId()));

			if (cartDetailInfo.getId() != null) {
				cartDetail = cartDetailDAO.findById(cartDetailInfo.getId(), true);
			}

			cartDetail.setQuantity(cartDetailInfo.getQuantity());
			cartDetailDAO.saveOrUpdate(cartDetail);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
