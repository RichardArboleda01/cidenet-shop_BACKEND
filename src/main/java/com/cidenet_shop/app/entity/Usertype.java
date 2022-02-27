 package com.cidenet_shop.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Usertype implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_Role")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	
	@Column(name = "role_Type")
	private String roleType;

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	
} 
