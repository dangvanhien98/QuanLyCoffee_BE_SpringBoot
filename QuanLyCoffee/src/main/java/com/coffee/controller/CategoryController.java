package com.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.model.CategoryModel;
import com.coffee.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping
	public ResponseEntity<?> getAllCategory() {
		List<CategoryModel> categories = categoryService.getAllCategory();
		if (categories != null)
			return new ResponseEntity<List<CategoryModel>>(categories, HttpStatus.OK);
		return new ResponseEntity<String>("not found category in database", HttpStatus.OK);
	}
}
