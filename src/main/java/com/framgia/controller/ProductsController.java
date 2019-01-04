package com.framgia.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framgia.model.ProductInfo;
import com.framgia.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController extends BaseController{
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<ProductInfo> showProducts(@RequestParam("pageStart") int pageStart) {
		return productService.getProducts(pageStart);
	}
	
	//show information of product by single.jsp
	@GetMapping(value="/{id}")
	public String showSingleProduct(@PathVariable("id") Integer id ,Model model, HttpSession httpSession) {
		
		//add list product
		model.addAttribute("products", productService.getProductsByCategoryID(id));
		
		//add 1 productInfo
		model.addAttribute("product", productService.getProductById(id));
		return "client-single-product";
	}
}
