package com.framgia.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.framgia.service.CategoryService;
public class BaseController {
	@Autowired
	protected CategoryService categoryService;
	
/*	@Autowired
	protected ProductService productService;
	
	@Autowired
	protected GoogleUtils googleUtils;
	
	@Autowired
	protected UserService userService;*/
	
}
