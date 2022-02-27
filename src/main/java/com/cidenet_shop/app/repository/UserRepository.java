package com.cidenet_shop.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cidenet_shop.app.entity.Client;

@Repository
public interface UserRepository extends JpaRepository <Client, Long> {

	// validate if the  email exist 
	
	@Query(value = "select count(*) from Client where email = ?", nativeQuery = true)
	public int findByemail(String email);
	
	// validate email and pass for login
	
	@Query(value = "select * from Client where email = ? and password = ?", nativeQuery = true)
	public Client loginUser(String email, String password);
	
	// validate find user by email for user login
	
	@Query(value = "select * from Client where email = ?", nativeQuery = true)
	public Client findByEmailUser(String email);
	
	public Client findByIdCard(Long idCard);
	
}
