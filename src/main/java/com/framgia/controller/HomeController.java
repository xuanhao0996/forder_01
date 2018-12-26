package com.framgia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController {

	@GetMapping(value = "/")
	public String index(Model model, HttpSession httpSession) {
		httpSession.setAttribute("categories", categoryService.getCategories());
		double sumPage = Math.ceil((double) productService.getProducts(-1).size() / 4);

		model.addAttribute("products", productService.getProducts(0));
		model.addAttribute("sumPage", sumPage);
		return "client-index";
	}

}
