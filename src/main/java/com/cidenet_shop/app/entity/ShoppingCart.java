package com.cidenet_shop.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {
	
	private static final long serialVersionUID = -222442973567217888L;

	@Id
	@Column(name = "id_cart")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCart;

	@Column(name = "subtotal")
	private int subtotal;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "delivery")
	private int delivery;
	
	@Column(name = "total")
	private int total;
	
	@ManyToMany
	@Column(name = "cart_product")
	private List<Product> cartProduct;
	
	@JoinColumn(name="userBuy")
	@ManyToOne
	private Client userBuy;

	public Long getIdCart() {
		return idCart;
	}

	public void setIdCart(Long idCart) {
		this.idCart = idCart;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Product> getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(List<Product> cartProduct) {
		this.cartProduct = cartProduct;
	}

	public Client getUserBuy() {
		return userBuy;
	}

	public void setUserBuy(Client userBuy) {
		this.userBuy = userBuy;
	}

	
	
	
	
	
}
