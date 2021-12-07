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
public class Roles implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_Role", nullable = false, unique =  true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRole;
	
	@Column(name = "role_Type", nullable = false)
	private String roleType;

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

}
