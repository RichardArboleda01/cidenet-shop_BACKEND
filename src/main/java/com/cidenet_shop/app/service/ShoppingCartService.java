package com.cidenet_shop.app.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cidenet_shop.app.entity.Product;
import com.cidenet_shop.app.entity.ShoppingCart;
import com.cidenet_shop.app.repository.ProductRepository;
import com.cidenet_shop.app.repository.ShoppingCartRepository;
import com.cidenet_shop.app.response.CustomResponse;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private JavaMailService javaMailService;
	
	public ResponseEntity<Object> createCart(@RequestBody ShoppingCart NewShoppingCart) {
		ResponseEntity<Object> response;
		try {
			CustomResponse res = new CustomResponse("Carrito creado con exito", HttpStatus.OK);
			String message02 = "";
			for(Product varProduct : NewShoppingCart.getCartProduct()){
				message02 += varProduct.getName() + " cantidad = " + varProduct.getUnits() + "\n";
				varProduct.setUnits(0);
				productRepository.save(varProduct);
			}
			String message = "Hola " + NewShoppingCart.getUserBuy().getFirstName() + " aca esta tu recibo de compra :D \n" + "será enviado a la direccion: " + NewShoppingCart.getUserBuy().getAddress() + "\n" + message02;
			javaMailService.sendMail("cidenetshopsh@gmail.com", NewShoppingCart.getUserBuy().getEmail(), "Compra Cidenet Shop", message);
			res.setObjectResponse(shoppingCartRepository.save(NewShoppingCart));
			System.out.println("llego 2");
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de crear el producto",
					HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	
	public ResponseEntity<Object> getAllShoppingCart() {
		ResponseEntity<Object> response;
		try {
			List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll();
			CustomResponse res = new CustomResponse("Carritos de compra consultados con exito", HttpStatus.OK);
			res.setObjectResponse(shoppingCartList);
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los Carritos de compra",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}

	
	public ResponseEntity<Object> getByClient(@RequestParam Long idClient) {
		ResponseEntity<Object> response;
		try {
			List<ShoppingCart> shoppingCartList = shoppingCartRepository.findByIdClient(idClient);
			CustomResponse res = new CustomResponse("Carritos de compra consultados con exito", HttpStatus.OK);
			res.setObjectResponse(shoppingCartList);
			response = ResponseEntity.ok(HttpStatus.OK);
			response = new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			response = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			response = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los Carritos de compra",
					HttpStatus.BAD_REQUEST);

		}
		return response;
	}

	

}
