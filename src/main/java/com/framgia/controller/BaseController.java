package com.framgia.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.framgia.service.CartDetailService;
import com.framgia.service.CartService;
import com.framgia.service.CategoryService;
import com.framgia.service.ProductService;
import com.framgia.service.UserService;

public class BaseController {
	@Autowired
	protected CategoryService categoryService;
	
	@Autowired
	protected ProductService productService;
	
	/*@Autowired
	protected GoogleUtils googleUtils;
	*/
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected CartService cartService;
	
	@Autowired
	protected CartDetailService cartDetailService;
}
