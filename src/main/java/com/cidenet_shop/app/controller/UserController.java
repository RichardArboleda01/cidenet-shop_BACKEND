package com.cidenet_shop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet_shop.app.entity.User;
import com.cidenet_shop.app.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/users/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("create")
	public String saveUser(@RequestBody User newUser) {
		return userService.saveUser(newUser);
	}

	@GetMapping("login")
	public String loginUser(@RequestParam String email, @RequestParam String password) {
		return userService.loginUser(email, password);
	}

}
