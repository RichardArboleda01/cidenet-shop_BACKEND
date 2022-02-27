package com.cidenet_shop.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet_shop.app.entity.ProductColor;
import com.cidenet_shop.app.service.ProductColorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/color/")
public class ProductColorController {
	
	@Autowired
	private ProductColorService productColorService;
	
	@GetMapping("getAll")
	public List<ProductColor> getAll() {
		return productColorService.getAllColor();
	}
	
	@PostMapping("create")
	public List <ProductColor> create(@RequestBody ProductColor newColor) {
		return productColorService.createColor(newColor);
	}

	
}
