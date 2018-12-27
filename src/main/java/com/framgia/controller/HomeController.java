package com.framgia.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.framgia.bean.CategoryInfo;
import com.framgia.service.CategoryService;
import com.framgia.service.ProductService;

@Controller
public class HomeController extends BaseController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/")
	public String index(Model model, HttpSession httpSession) {
		List<CategoryInfo> list = categoryService.getCategories();
		
		httpSession.setAttribute("categories",list );
		double sumPage = Math.ceil((double) productService.getProducts(-1).size() / 4);
		
		//model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("products", productService.getProducts(0));
		model.addAttribute("sumPage", sumPage);
		return "client-index";
	}

}
