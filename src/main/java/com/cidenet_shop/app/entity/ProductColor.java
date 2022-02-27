package com.cidenet_shop.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "ProductColor")
public class ProductColor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "idColor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idColor;
	
	@Column (name = "nameColor")
	private String nameColor;

	
	
	
	public Long getIdColor() {
		return idColor;
	}

	public void setIdColor(Long idColor) {
		this.idColor = idColor;
	}

	public String getNameColor() {
		return nameColor;
	}

	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}
	
}
