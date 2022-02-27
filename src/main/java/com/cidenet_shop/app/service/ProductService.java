package com.cidenet_shop.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.apache.log4j.*;
import com.cidenet_shop.app.entity.Product;
import com.cidenet_shop.app.repository.ProductRepository;
import com.cidenet_shop.app.response.CustomResponse;

@Service
public class ProductService {

	private static final Logger logger = Logger.getLogger(ProductService.class);
	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<Object> createProduct(@RequestBody Product newProduct) {

		ResponseEntity<Object> response;
		try {
			CustomResponse res = new CustomResponse("Producto creado con exito", HttpStatus.OK);
			res.setObjectResponse(productRepository.save(newProduct));
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de crear el producto",
					HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	public ResponseEntity<Object> getAllProducts() {

		ResponseEntity<Object> response;
		try {
			List<Product> productList = productRepository.findAll();
			CustomResponse res = new CustomResponse("Productos consultados con exito", HttpStatus.OK);
			res.setObjectResponse(productList);
			res.setTotalObject(productList.size());
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los productos",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}
	
	
	public ResponseEntity<Object> getProduct(@PathVariable Long idProduct) {

		ResponseEntity<Object> response;
		try {
			CustomResponse res = new CustomResponse("Producto consultado con exito", HttpStatus.OK);
			res.setObjectResponse(productRepository.FindByIdProduct(idProduct));
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el producto",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}

	public ResponseEntity<Object> getProductbyColor(@RequestParam Long idColor) {

		ResponseEntity<Object> response;
		try {
			List<Product> productsByColor = productRepository.findByColor(idColor);
			CustomResponse res = new CustomResponse("Producto por color consultado con exito", HttpStatus.OK);
			res.setObjectResponse(productsByColor);
			res.setTotalObject(productsByColor.size());
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el producto por color",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}

	public ResponseEntity<Object> getProductbySize(@RequestParam String size) {

		ResponseEntity<Object> response;
		try {
			List<Product> productsBySize = productRepository.findBySize(size);
			CustomResponse res = new CustomResponse("Producto por talla consultado con exito", HttpStatus.OK);
			res.setObjectResponse(productsBySize);
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el producto por talla",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}

	public ResponseEntity<Object> getProductbyBrand(@RequestParam String brand) {

		ResponseEntity<Object> response;
		try {
			List<Product> productsByBrand = productRepository.findByBrand(brand);
			CustomResponse res = new CustomResponse("Producto por marca consultado con exito", HttpStatus.OK);
			res.setObjectResponse(productsByBrand);
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el producto por marca",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}

	public ResponseEntity<Object> getProductbyPrice(@RequestParam int price) {

		ResponseEntity<Object> response;
		try {
			List<Product> productsByPrice = productRepository.findByPrice(price);
			CustomResponse res = new CustomResponse("Producto por precio consultado con exito", HttpStatus.OK);
			res.setObjectResponse(productsByPrice);
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el producto por precio",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}

	public ResponseEntity<Object> getProductbyCategory(@RequestParam String category) {

		ResponseEntity<Object> response;
		try {
			List<Product> productsByCategory = productRepository.findByCategory(category);
			CustomResponse res = new CustomResponse("Producto por categoria consultado con exito", HttpStatus.OK);
			res.setObjectResponse(productsByCategory);
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar el producto por categoria",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}
	
	public ResponseEntity<Object> deleteProduct(@RequestParam Long idProduct) {

		ResponseEntity<Object> response;
		try {
			CustomResponse res = new CustomResponse("Producto eliminado con exito", HttpStatus.OK);
			productRepository.deleteById(idProduct);
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error eliminando el producto",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}
	
	public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable Long idProduct) {
		ResponseEntity<Object> response;
		try {
			CustomResponse res = new CustomResponse("Actualizacion del producto exitosa", HttpStatus.OK);
			product.setIdProduct(idProduct);
			res.setObjectResponse(productRepository.save(product));
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		}catch(Exception e) {
			logger.error(e);
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de actualizar el producto", HttpStatus.BAD_REQUEST);
			
		}
		return response;

	}

}
