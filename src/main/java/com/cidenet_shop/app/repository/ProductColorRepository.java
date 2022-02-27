package com.cidenet_shop.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cidenet_shop.app.entity.ProductColor;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {

}