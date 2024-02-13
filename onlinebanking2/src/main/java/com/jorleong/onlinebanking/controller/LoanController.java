package com.jorleong.onlinebanking.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jorleong.onlinebanking.domain.Loan;
import com.jorleong.onlinebanking.service.LoanService;
import com.jorleong.onlinebanking.validation.LoanValidator;

@Controller
public class LoanController {
	
	@Autowired
	LoanValidator loanValidator;
	
	@Autowired
	LoanService loanService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(loanValidator);
	}
	
	@PostMapping(value="saveLoan")
	public String saveLoan(@ModelAttribute @Valid Loan loan, BindingResult result) {
		System.out.println("result.hasErrors(): "+ result.hasErrors());
		System.out.println(loan);
		if(result.hasErrors()){
			System.out.println("returning to accountForm.jsp");
			return "loan";
		}else{
			Calendar today = Calendar.getInstance();
			loan.setLoanDate(today.getTime());
			loanService.save(loan);
			//model.addAttribute("account", acc);
			System.out.println("returning to success.jsp, result.hasErrors():" + result.hasErrors());
			return "success";
		}
		
	}
	
	@GetMapping(value="/loan")
	public String getLoanForm(Model model, Loan loan) {
		return "loan";
	}
	
	
}
