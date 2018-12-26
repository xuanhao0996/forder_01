package com.framgia.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framgia.bean.ProductInfo;

@Controller
public class ProductsController extends BaseController{
	@RequestMapping(value = "products", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<ProductInfo> showProducts(@RequestParam("pageStart") int pageStart) {
		return productService.getProducts(pageStart);
	}
}
