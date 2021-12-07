package com.cidenet_shop.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/* import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException; */
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.cidenet_shop.app.entity.User;
import com.cidenet_shop.app.repository.UserRepository;
import com.cidenet_shop.app.validation.ValidateEmailUser;
import com.cidenet_shop.app.validation.ValidateExistUser;

@Service
public class UserService {//implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	// method to create a new user, validating if the user exist and email characters
	public String saveUser(@RequestBody User newUser) {

		/*newUser.setPassword(encoder.encode(newUser.getPassword()));*/
		ValidateEmailUser validateEmailUser = new ValidateEmailUser();
		ValidateExistUser validateExistUser = new ValidateExistUser();
		if ((validateExistUser.existUser(userRepository.findByemail(newUser.getEmail())) == true)) {
			return "El usuario ya existe.";
		}
	        if (validateEmailUser.validateEmailUser(newUser.getEmail()) == false) {
	           return "El correo es incorrecto"; 
	        }
		else {
			userRepository.save(newUser);
			return "Se ha registrado con exito";

		}

	}

	// method login user
	public String loginUser (@RequestParam String email, @RequestParam String password) {
		ValidateExistUser validateExistUser = new ValidateExistUser();
		if (validateExistUser.existUser(userRepository.findByemail(email)) == true) {
			User loginUser = userRepository.loginUser(email, password);
			return loginUser.getFirstName();
		} 
		return "Error: No se encontró el usuario";
		
	}

	/* @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User userByEmail = userRepository.findByEmailUser(email);
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		UserDetails user = new org.springframework.security.core.userdetails.User(userByEmail.getEmail(), userByEmail.getPassword(), roles);
		return user;
		
	} */
	
}
