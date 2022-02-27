package com.cidenet_shop.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Client")
public class Client implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_card")
	private Long idCard;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "idcard_type")
	private String idCardType;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "Confirm_password")
	private String ConfirmPassword;
	
	@Column(name = "address")
	private String address;
	
	/* @OneToOne
	@Column(name = "id_Role")
	private Usertype idRole;
	
	
	public Usertype getIdRole() {
		return idRole;
	} 

	public void setIdRole(Usertype idRole) {
		this.idRole = idRole;
	} */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
