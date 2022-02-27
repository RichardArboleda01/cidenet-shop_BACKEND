package com.cidenet_shop.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cidenet_shop.app.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{
	
	@Query(value = "select * from ShoppingCart where User_buy = ?", nativeQuery = true)
	public List<ShoppingCart> findByIdClient(Long idClient);
	

}
