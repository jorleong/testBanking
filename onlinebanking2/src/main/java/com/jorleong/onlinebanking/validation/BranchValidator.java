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

import com.jorleong.onlinebanking.domain.Branch;
import com.jorleong.onlinebanking.service.BranchService;

@Component
public class BranchValidator implements Validator {
	
	@Autowired
//	@Qualifier(value="branchServiceJpa")
	BranchService branchService;
	
	@Override
	public boolean supports(Class<?> arg0) {		
		return Branch.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Branch branch =  (Branch) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bCode", "branch.bCode", "Branch code is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "branch.name", "Branch name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "branch.location", "Location is required");
		
		if(branchService.existsById(branch.getbCode())){
			errors.rejectValue("bCode", "Branch.bCode.exists", "Branch code:  "+ branch.getbCode() + " already exists");
		}
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<Branch>>  constraintViolations = validator.validate(branch);
		
		for(ConstraintViolation<Branch> cv : constraintViolations){
			System.out.println(cv.getInvalidValue() + ":    "+cv.getMessage());
		}
		
	}  // end of validate()
	 

}
