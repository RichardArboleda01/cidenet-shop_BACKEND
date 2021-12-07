package com.cidenet_shop.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User implements Serializable{
	
	private static final long serialVersionUID = -222442973567217888L;

	@Id
	@Column(name = "id_card", nullable = false, unique =  true, length = 50)
	private Long idCard;
	
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
	@Column(name = "idcard_type", nullable = false, length = 50)
	private String idCardType;
	
	@Column(name = "email", nullable = false, unique = true, length = 100)
	private String email;
	
	@Column(name = "password" , nullable = false, length = 255)
	private String password;
	
	/* @OneToOne
	@Column(name = "id_Role")
	private Roles idRole;
	
	public Roles getIdRole() {
		return idRole;
	} 

	public void setIdRole(Roles idRole) {
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
	
}
