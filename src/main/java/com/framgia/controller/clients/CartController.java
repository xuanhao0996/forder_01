package com.framgia.controller.clients;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.framgia.model.CartDetailInfo;
import com.framgia.model.CartInfo;
import com.framgia.model.ProductInfo;
import com.framgia.model.UserInfo;
import com.framgia.service.CartService;
import com.framgia.service.ProductService;
import com.framgia.service.UserService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/addToCart/{id}")
	public String addToCart(@PathVariable("id") Integer productId, Model model, HttpSession httpSession) {

		// check product have exist
		if (productService.getProductById(productId) == null) {
			// add message error exist product
			return "redirect:/";
		}

		// get current-user(logging) by session
		UserInfo currentUser = (UserInfo) httpSession.getAttribute("user");

		String emailCurrent = currentUser.getEmail();

		// check user have exist in database
		if (userService.findByEmail(emailCurrent) == null) {
			// tu add them message bao ko ton tai user
			return "redirect:/";
		}

		// check cart exist
		CartInfo cartInfo = cartService.getCartByUserId(currentUser.getId());
		if (cartInfo == null) {
			cartService.createCart(currentUser, productId);

			// add message create cart success
			return "redirect:/";
		}

		// cart is existed
		cartService.saveOrUpdateCartDetail(getCartDetail(cartInfo, productId));

		// add message create cart success
		return "redirect:/";

	}

	@GetMapping(value = "/cart")
	public String showCart(HttpSession httpSession, Model mode) {
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("user");
		CartInfo cartInfo = cartService.getCartByUserId(userInfo.getId());
		List<CartDetailInfo> cartDetailInfos = cartService.findCartDetailByCartId(cartInfo.getId());
		// get product by cart-detail-id
		List<ProductInfo> productInfos = new ArrayList<ProductInfo>();
		for (CartDetailInfo cartDetailInfo : cartDetailInfos) {
			ProductInfo productInfo = new ProductInfo();
			productInfo = cartService.getProductByCartDetailId(cartDetailInfo.getId());
			productInfos.add(productInfo);
		}
		mode.addAttribute("products", productInfos);
		return "client-cart";
	}

	// logic set quantity for cart detail
	private CartDetailInfo getCartDetail(CartInfo cartInfo, int productId) {
		List<CartDetailInfo> cartDetailInfos = cartService.findCartDetailByCartId(cartInfo.getId());

		CartDetailInfo cartDetailInfo = new CartDetailInfo();
		cartDetailInfo.setCart(new CartInfo(cartInfo.getId()));
		cartDetailInfo.setProduct(new ProductInfo(productId));

		boolean isExist = false;

		for (CartDetailInfo item : cartDetailInfos) {
			if (isExist) {
				break;
			}

			// get product in current-cartDetail to update
			if (item.getProduct().getId() == productId) {
				cartDetailInfo.setId(item.getId());
				cartDetailInfo.setQuantity(item.getQuantity() + 1);
				isExist = true;
			}
		}

		// add record into cart detail table
		if (!isExist) {
			cartDetailInfo.setQuantity(1);
		}
		
		return cartDetailInfo;
	}

}
