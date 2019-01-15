package com.framgia.controller.admins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.controller.BaseController;

@Controller
public class ProductsController extends BaseController {

	@RequestMapping(value = "/products/{productId}",method = RequestMethod.GET)
	public String showSingleProduct(@PathVariable("productId") Integer productId, Model model) {
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("product", productService.findById(productId));
		return "client-single-product";
	}
	@RequestMapping(value = "/admin/products/",method = RequestMethod.GET)
	public String showProductAdmin() {
		return "product";
	}
}