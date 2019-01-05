package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;

import com.framgia.bean.ProductInfo;
import com.framgia.model.Product;

public class ConvertProduct {
	static Function<Product, ProductInfo> convertProductToProductInfo = (Product p) -> {
		ProductInfo pInfo = new ProductInfo();
		pInfo.setId(p.getId());
		pInfo.setName(p.getName());
		pInfo.setPrice(p.getPrice());
		pInfo.setImage(p.getImage());
		return pInfo;
	};
	
	public static ProductInfo productToProductInfo(Product product) {
		ProductInfo productInfo = new ProductInfo();
		BeanUtils.copyProperties(product, productInfo);
		return productInfo;
	}
	
	public static List<ProductInfo> listProToProInfo(List<Product> lProduct) {
		List<ProductInfo> arr = new ArrayList<>();
		for (Product p : lProduct) {
			arr.add(convertProductToProductInfo.apply(p));
		}
		return arr;
	}

	public static Product productInfoToProduct(ProductInfo entity) {
		Product product = new Product();
		BeanUtils.copyProperties(entity, product);
		return product;
	}
}
