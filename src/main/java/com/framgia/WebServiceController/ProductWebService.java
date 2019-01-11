package com.framgia.WebServiceController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.framgia.bean.CategoryInfo;
import com.framgia.bean.ProductInfo;
import com.framgia.controller.BaseController;
import com.framgia.hepler.ConvertDateSql;

@RestController
@RequestMapping(value = "/products/")
public class ProductWebService extends BaseController {

	@GetMapping
	public ResponseEntity<List<ProductInfo>> getAll() {
		List<ProductInfo> arrProduct = productService.getAll();
		
		if (arrProduct == null || arrProduct.isEmpty()) {
			return new ResponseEntity<List<ProductInfo>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ProductInfo>>(arrProduct, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductInfo> getProductById(@PathVariable("id") Integer id) {
		ProductInfo productInfo = productService.findById(id);
		
		if (productInfo == null) {
			return new ResponseEntity<ProductInfo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductInfo>(productInfo, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProductInfo> deleteProduct(@PathVariable Integer id) {
		ProductInfo productInfo = productService.findById(id);
		
		if (productInfo == null) {
			return new ResponseEntity<ProductInfo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductInfo>(productInfo, HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/products/")
	public ResponseEntity<Void> createProduct(@RequestBody ProductInfo productInfo,
			UriComponentsBuilder uriComponentsBuilder) {
		
		if (productService.findByName(productInfo.getName()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		productService.saveOrUpdate(productInfo);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders
				.setLocation(uriComponentsBuilder.path("/products/{id}").buildAndExpand(productInfo.getId()).toUri());
		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);

	}

	@PutMapping(value = "/products/{id}")
	public ResponseEntity<ProductInfo> updateProduct(@PathVariable("id") Integer id,
			@RequestBody ProductInfo productInfo) {
		
		if (productService.findById(id) != null) {
			return new ResponseEntity<ProductInfo>(HttpStatus.NOT_FOUND);
		}
		productService.saveOrUpdate(productInfo);
		return new ResponseEntity<ProductInfo>(productInfo, HttpStatus.OK);
	}
}
