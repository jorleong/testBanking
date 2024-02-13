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

import com.jorleong.onlinebanking.domain.Loan;
import com.jorleong.onlinebanking.service.BranchService;
import com.jorleong.onlinebanking.service.CustomerService;
import com.jorleong.onlinebanking.service.LoanService;

@Component
public class LoanValidator implements Validator{

	@Autowired
	CustomerService customerService;
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	BranchService branchService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Loan.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Loan loan =  (Loan) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer", "loan.customer", "Customer Id does not exist.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "loan.amount", "Loan amount is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loanType", "loan.loanType", "Loan type is required");
		
//		if(account.getAccBalance()<=100){
//			errors.rejectValue("accBalance", "account.accBalance.value", "Balance should be > than 100." );
//		}	
		if(loan.getCustomer() != null) {// check if field is not null
			Long custId = loan.getCustomer().getCustomerId();
			if(custId != null) {
				if(customerService.existsById(loan.getCustomer().getCustomerId()) == false){ //check if the customer in database exists or not
					errors.rejectValue("loanId", "loan.loanId.exists", "loan:  "+ loan.getLoanId() + " already exists.");
				}
			}
		}
		if(!branchService.existsById(loan.getbCode())){
			errors.rejectValue("bCode", "Branch.bCode.exists", "Branch code:  "+ loan.getbCode() + " does not exist");
		}
		
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<Loan>>  constraintViolations = validator.validate(loan);
		
		for(ConstraintViolation<Loan> cv : constraintViolations){
			System.out.println(cv.getInvalidValue() + ":    "+cv.getMessage());
		}
		
	}  // end of validate()

}
