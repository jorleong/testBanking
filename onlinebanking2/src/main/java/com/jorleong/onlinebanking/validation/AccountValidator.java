package com.jorleong.onlinebanking.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jorleong.onlinebanking.domain.Account;
import com.jorleong.onlinebanking.service.AccountService;


@Component
public class AccountValidator implements Validator {
	
	@Autowired
//	@Qualifier(value="accountServiceJpa")
	AccountService accountService;

	@Override
	public boolean supports(Class<?> arg0) {		
		return Account.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Account account =  (Account) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accNo", "account.accNo", "Account number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accType", "account.accType", "Account type is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accHolderName", "account.accHolderName", "Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accBalance", "account.accBalance", "Balance is required.");
		
		if(account.getAccBalance()<=100){
			errors.rejectValue("accBalance", "account.accBalance.value", "Balance should be > than 100." );
		}	
		
//		if(accountService.existsById(account.getAccNo())){
//			errors.rejectValue("accNo", "account.accNo.exists", "Account number:  "+ account.getAccNo() + " already exists.");
//		}
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<Account>>  constraintViolations = validator.validate(account);
		
		for(ConstraintViolation<Account> cv : constraintViolations){
			System.out.println(cv.getInvalidValue() + ":    "+cv.getMessage());
		}
		
	}  // end of validate()
	 

}
