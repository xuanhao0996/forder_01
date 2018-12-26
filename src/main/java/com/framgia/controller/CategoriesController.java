package com.framgia.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framgia.bean.CategoryInfo;
import com.framgia.service.ProductService;

@Controller
@RequestMapping(value="/categories")
public class CategoriesController {
	
	@Autowired
	private ProductService productService;

	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/categories/{id}")
	public String showCategory(@PathVariable("id") Integer id, Model model, HttpSession httpSession) {

		model.addAttribute("products", productService.getProductsByCategoryID(id));
		model.addAttribute("products", (List<CategoryInfo>) httpSession.getAttribute("categories"));

		return "client-category";
	}
	
}
