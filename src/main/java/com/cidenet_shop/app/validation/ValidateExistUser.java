package com.cidenet_shop.app.validation;

public class ValidateExistUser {

	public boolean existUser(int countEmail) {
		if (countEmail > 0) {
			return true;
		} else {
			return false;
		}
	}
}
