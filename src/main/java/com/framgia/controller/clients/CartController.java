package com.framgia.controller.clients;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import com.framgia.bean.CartDetailInfo;
import com.framgia.bean.CartInfo;
import com.framgia.bean.UserInfo;
import com.framgia.controller.BaseController;

@Controller
@RequestMapping(value = "/cart")
public class CartController extends BaseController {

	@GetMapping(value = "/{productId}")
	public String addToCart(@PathVariable("productId") Integer productId, HttpSession httpSession) {

		// check product exist
		if (productService.findById(productId) == null) {
			return "redirect:/";
		}

		UserInfo currentUser = (UserInfo) httpSession.getAttribute("currentUser");
		String emailCurrent = currentUser.getEmail();

		// check user have exist in database
		if (userService.findByEmail(emailCurrent) == null) {
			// add message:no user
			return "redirect:/";
		}
		// check cart
		if (cartService.findByUserId(currentUser.getId()) == null) {
			// create cart and cartDetail if user don't have cart
			CartInfo cartInfo = new CartInfo();
			cartInfo.setStatus(0);
			List<CartInfo> cartInfos = currentUser.getCarts();
			cartInfos.add(cartInfo);
		}

		showMyCart(httpSession);
		return "client-cart";
	}

	private void showMyCart(HttpSession httpSession) {
		// get cart of current user
		UserInfo currentUser = (UserInfo) httpSession.getAttribute("currentUser");
		ArrayList<CartInfo> carts = (ArrayList<CartInfo>) cartService.findByUserId(currentUser.getId());
		for (CartInfo cartInfo : carts) {
			if (cartInfo.getStatus() == 0) {
				ArrayList<CartDetailInfo> cartDetailInfos = (ArrayList<CartDetailInfo>) cartDetailService
						.findByCartInfoId(cartInfo.getId());
				int count = 0;
				for (CartDetailInfo cartDetailInfo : cartDetailInfos) {
					count = count + cartDetailInfo.getQuantity();
				}
				httpSession.setAttribute("countProduct", count);
			}
		}
	}
}
