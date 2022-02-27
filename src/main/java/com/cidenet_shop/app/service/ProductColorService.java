package com.cidenet_shop.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cidenet_shop.app.entity.ProductColor;
import com.cidenet_shop.app.repository.ProductColorRepository;

@Service
public class ProductColorService {

	@Autowired
	private ProductColorRepository productColorRepository;
	
	
	public List<ProductColor> getAllColor() {
		return this.productColorRepository.findAll();
	}
	
	public List<ProductColor> createColor(@RequestBody ProductColor newColor) {
		 this.productColorRepository.save(newColor);
		 return this.productColorRepository.findAll();
	}
	
	public List<ProductColor> deleteColor(@RequestParam Long idColor) {
		this.productColorRepository.deleteById(idColor);
		return this.productColorRepository.findAll();
	}
	
}
