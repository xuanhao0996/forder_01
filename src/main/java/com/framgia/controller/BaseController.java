package com.framgia.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.framgia.service.CategoryService;
import com.framgia.service.ProductService;

public class BaseController {
	@Autowired
	protected CategoryService categoryService;
	@Autowired
	protected ProductService productService;
}
