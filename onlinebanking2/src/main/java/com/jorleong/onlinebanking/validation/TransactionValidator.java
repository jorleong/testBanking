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

import com.jorleong.onlinebanking.domain.Transaction;
import com.jorleong.onlinebanking.service.AccountService;
import com.jorleong.onlinebanking.service.TransactionService;

@Component
public class TransactionValidator implements Validator {
	
	@Autowired
//	@Qualifier(value="accountServiceJpa")
	TransactionService transactionService;

	@Autowired
	AccountService accountService;
	
	@Override
	public boolean supports(Class<?> arg0) {		
		return Transaction.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Transaction transaction =  (Transaction) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromAcc", "transaction.toAcc", "Account number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toAcc", "transaction.fromAcc", "Account number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accTx", "transaction.accTx", "Transfer amount is required");

		
		if(transaction.getAccTx()<=0){
			errors.rejectValue("accTx", "transaction.accTx.value", "Balance should be > than 0." );
		}	
		
		if(!accountService.existsById(transaction.getFromAcc())){
			errors.rejectValue("fromAcc", "transaction.fromAcc.exists", "Account number:  "+ transaction.getFromAcc() + " does not exist");
		}
		if(!accountService.existsById(transaction.getToAcc())){
			errors.rejectValue("toAcc", "transaction.toAcc.exists", "Account number:  "+ transaction.getToAcc() + " does not exist");
		}
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<Transaction>>  constraintViolations = validator.validate(transaction);
		
		for(ConstraintViolation<Transaction> cv : constraintViolations){
			System.out.println(cv.getInvalidValue() + ":    "+cv.getMessage());
		}
		
	}  // end of validate()
	 

}
