package com.framgia.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framgia.bean.CategoryInfo;
import com.framgia.service.CategoryService;
import com.framgia.service.ProductService;

@Controller
@RequestMapping(value="/categories")
public class CategoriesController {
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/{id}")
	public String showCategory(@PathVariable("id") Integer id, Model model, HttpSession httpSession) {
		
		CategoryInfo categoryInfo = categoryService.getCategoryById(id);
		model.addAttribute("category", categoryInfo);
		model.addAttribute("products",productService.getProductsByCategoryID(id));

		return "client-category";
	}
	
}
