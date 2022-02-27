package com.cidenet_shop.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name = "id_product")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idProduct;
		
		@Column(name = "category")
		private String category;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "price")
		private int price;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "picture")
		private String picture;
		
		@ManyToMany
		@JoinColumn(name = "idColor")
		private List<ProductColor> idColor;
		
		@Column(name = "brand")
		private String brand;
		
		@Column(name = "size")
		private String size;
		
		@Column(name = "stock")
		private int stock;
		
		@Column(name = "units")
		private int units = 0;
		
		
	
		

		public int getUnits() {
			return units;
		}

		public void setUnits(int units) {
			this.units = units;
		}

		public List<ProductColor> getIdColor() {
			return idColor;
		}

		public void setIdColor(List<ProductColor> idColor) {
			this.idColor = idColor;
		}

		public Long getIdProduct() {
			return idProduct;
		}

		public void setIdProduct(Long idProduct) {
			this.idProduct = idProduct;
		}

		
		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPicture() {
			return picture;
		}

		public void setPicture(String picture) {
			this.picture = picture;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		
}
