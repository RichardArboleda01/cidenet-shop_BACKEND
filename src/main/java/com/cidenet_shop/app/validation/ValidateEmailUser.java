package com.cidenet_shop.app.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmailUser {

	//validation of the email, if it is valid, correct and if it exists
	
	public boolean validateEmailUser(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		return mather.find();
	}
}
