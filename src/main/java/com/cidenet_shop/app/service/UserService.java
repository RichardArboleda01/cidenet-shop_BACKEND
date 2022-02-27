package com.cidenet_shop.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.cidenet_shop.app.entity.Client;
import com.cidenet_shop.app.repository.UserRepository;
import com.cidenet_shop.app.validation.ValidateEmailUser;
import com.cidenet_shop.app.validation.ValidateExistUser;

@Service
public class UserService /* implements UserDetailsService */ {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	// method to create a new user, validating if the user exist and email
	// characters
	public Client saveUser(@RequestBody Client newUser) {

		// newUser.setPassword(encoder.encode(newUser.getPassword()));
		ValidateEmailUser validateEmailUser = new ValidateEmailUser();
		ValidateExistUser validateExistUser = new ValidateExistUser();
		if ((validateExistUser.existUser(userRepository.findByemail(newUser.getEmail())) == true)) {
			return null;
		}
		if (validateEmailUser.validateEmailUser(newUser.getEmail()) == false) {
			return null;
		} else {
			userRepository.save(newUser);
			return userRepository.findByIdCard(newUser.getIdCard());

		}

	}

	// method login user
	public Client loginUser(@RequestParam String email, @RequestParam String password) {
		ValidateExistUser validateExistUser = new ValidateExistUser();
		if (validateExistUser.existUser(userRepository.findByemail(email)) == true) {
			Client loginUser = userRepository.loginUser(email, password);
			return loginUser;
		}
		return null;

	}
	
	public Client getUser(@PathVariable Long idClient) {
		return this.userRepository.getById(idClient);

	}

	/*
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User userByEmail = userRepository.findByEmailUser(email);
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		UserDetails user = new org.springframework.security.core.userdetails.User(userByEmail.getEmail(),
				userByEmail.getPassword(), roles);
		return user;

	} */

}
