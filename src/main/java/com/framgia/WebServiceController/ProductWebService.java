package com.framgia.WebServiceController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framgia.bean.ProductInfo;
import com.framgia.controller.BaseController;

@RestController
public class ProductWebService extends BaseController {
	
	@RequestMapping(value = "/products/", method = RequestMethod.GET)
	public ResponseEntity<List<ProductInfo>> getAll() {
		List<ProductInfo> arrProduct = productService.getAll();
		if (arrProduct == null || arrProduct.isEmpty()) {
			return new ResponseEntity<List<ProductInfo>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductInfo>>(arrProduct, HttpStatus.OK);

	}
}
