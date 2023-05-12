package com.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.model.ProductModel;
import com.coffee.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping
	public ResponseEntity<?> getAllProduct(){
		List<ProductModel> products = productService.getAllProduct();
		if(products != null)
			return new ResponseEntity<List<ProductModel>>(products, HttpStatus.OK);
		return new ResponseEntity<String>("not found product in database", HttpStatus.OK);
	}
}
