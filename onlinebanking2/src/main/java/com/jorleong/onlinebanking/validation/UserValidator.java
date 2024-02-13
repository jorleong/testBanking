package com.jorleong.onlinebanking.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jorleong.onlinebanking.domain.User;
import com.jorleong.onlinebanking.service.UserService;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username.required", "Username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.required", "Password is required");
		
		if(user.getUsername().length()<5 || user.getUsername().length()>15) {
			errors.rejectValue("username", "username.length" , "Username must be between 5 - 15 characters");
		}
		if(user.getPassword().length()<5 || user.getPassword().length()>15) {
			errors.rejectValue("password", "username.password" , "Password must be between 5 - 15 characters");
		}
		if(userService.findByUsername(user.getUsername())!=null) {
			errors.rejectValue("username", "username.exists" , "Username already taken");
			user.setUsername("");
		}
		
		
	}

}
