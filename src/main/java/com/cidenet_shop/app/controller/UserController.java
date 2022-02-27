package com.cidenet_shop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet_shop.app.entity.Client;
import com.cidenet_shop.app.service.UserService;
//import com.cidenet_shop.app.utils.JWTUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/users/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/* @Autowired
	private JWTUtil jwtUtil; */
	
	@PostMapping("create")
	public Client saveUser(@RequestBody Client newUser) {
		return userService.saveUser(newUser);
	}

	@GetMapping("login")
	public Client loginUser(@RequestParam String email, @RequestParam String password) {
		
		/* String tokenJwt = jwtUtil.create(email, password); */
		
		return userService.loginUser(email, password);
	}
	
	@GetMapping("getClient")
	public Client getUser(@PathVariable Long idClient) {
		return userService.getUser(idClient);
	}

}
