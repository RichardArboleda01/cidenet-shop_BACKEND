package com.cidenet_shop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet_shop.app.entity.Product;
import com.cidenet_shop.app.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/products/")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;

	@PostMapping("create")
	public ResponseEntity<Object> createProduct(@RequestBody Product newProduct) {
		return productService.createProduct(newProduct);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<Object> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("getProductById/{idProduct}")
	public ResponseEntity<Object> getProduct(@PathVariable Long idProduct){
		return productService.getProduct(idProduct);
	}
	
	@GetMapping("getByColor")
	public ResponseEntity<Object> getProductByColor(@RequestParam Long idColor){
		return productService.getProductbyColor(idColor);
	}
	
	
	@GetMapping("getBySize")
	public ResponseEntity<Object> getProductBySize(@RequestParam String size){
		return productService.getProductbySize(size);
	}
	
	@GetMapping("getByBrand")
	public ResponseEntity<Object> getProductByBrand(@RequestParam String brand){
		return productService.getProductbyBrand(brand);
	}
	
	@GetMapping("getByPrice")
	public ResponseEntity<Object> getProductByPrice(@RequestParam int price){
		return productService.getProductbyPrice(price);
	}

	@GetMapping("getByCategory")
	public ResponseEntity<Object> getProductByCategory(@RequestParam String category){
		return productService.getProductbyCategory(category);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Object> deleteProduct(@RequestParam Long idProduct) {
		return productService.deleteProduct(idProduct);
	}
	
	@PutMapping("update/{idProduct}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable Long idProduct) {
		return productService.updateProduct(product, idProduct);
	}
	
	
}
