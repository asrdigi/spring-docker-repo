package com.adp.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adp.spring.model.Product;

@RestController
@RequestMapping("api/v1")
public class ProductController {
	private static List<Product> productList= new ArrayList<>();
	
	static {
		productList.add(new Product(1,"Apple","Apple Mac1",10,189765.0));
		productList.add(new Product(2,"Apple","Apple Mac2",10,199765.0));
		productList.add(new Product(3,"Apple","Apple Watch",30,79760.0));
		productList.add(new Product(4,"Apple","Apple iPhone 14 Max",10,89765.0));
		productList.add(new Product(5,"Samsung","Samsung GalaxyS23",15,55999.0));
	}
	
	@RequestMapping("/products")
	List<Product> getAllProducts(){
		return productList;
	}

}
