package com.framgia.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.framgia.dao.CartDAO;
import com.framgia.dao.GenericDAO;
import com.framgia.dao.ProductDAO;
import com.framgia.entity.Cart;
import com.framgia.entity.CartDetail;
import com.framgia.entity.Product;
import com.framgia.entity.User;

public class CartDAOImpl extends GenericDAO<Integer, Cart> implements CartDAO {
	@Autowired
	private ProductDAO productDAO;

	@Override
	public Cart getCartByUserId(Integer id) {
		return getSession().createQuery("from Cart c where c.user.id = :id", Cart.class).setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public Cart createCart(User user) {
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setStatus(0);
		getSession().saveOrUpdate(cart);
		return cart;
	}

	@Override
	public CartDetail createCartDetail(Cart cart, Integer productId) {
		CartDetail cartDetail = new CartDetail();
		cartDetail.setCart(cart);
		cartDetail.setProduct(productDAO.getProductsById(productId));
		cartDetail.setQuantity(0);
		getSession().saveOrUpdate(cartDetail);
		return cartDetail;
	}

	@Override
	public List<CartDetail> findCartDetailByCartId(Integer id) {
		return getSession()
				.createQuery(
						"select cd from CartDetail cd inner join Cart c " + "on cd.cart.id = c.id "
								+ "inner join Product p on cd.product.id = p.id " + "where c.id = :id",
						CartDetail.class)
				.setParameter("id", id).getResultList();
	}

	@Override
	public Product getProductByCartDetailId(Integer id) {
		return (Product) getSession().createQuery(
				"select p from Product p " + "inner join CartDetail c on p.id = c.product.id " + "where c.id = :id")
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public void saveOrUpdateCartDetail(CartDetail cartDetail) {
		getSession().saveOrUpdate(cartDetail);
	}

}
