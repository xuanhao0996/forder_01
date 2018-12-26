package com.framgia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.framgia.service.CategoryService;
import com.framgia.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/")
	public String index(Model model, HttpSession httpSession) {
		httpSession.setAttribute("categories", categoryService.getCategories());
		model.addAttribute("products", productService.getProducts());

		return "client-index";
	}

}
