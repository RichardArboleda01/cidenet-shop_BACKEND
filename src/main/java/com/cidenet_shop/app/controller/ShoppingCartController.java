package com.cidenet_shop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet_shop.app.entity.ShoppingCart;
import com.cidenet_shop.app.service.ShoppingCartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/cart/")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PostMapping("create")
	public ResponseEntity<Object> createProduct(@RequestBody ShoppingCart NewshoppingCart) {
		return shoppingCartService.createCart(NewshoppingCart);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<Object> getAllProducts(){
		return shoppingCartService.getAllShoppingCart();
	}
	
	
}
