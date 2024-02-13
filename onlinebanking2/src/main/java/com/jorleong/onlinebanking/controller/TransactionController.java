package com.jorleong.onlinebanking.controller;

import java.util.Calendar;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorleong.onlinebanking.domain.Transaction;
import com.jorleong.onlinebanking.service.AccountService;
import com.jorleong.onlinebanking.service.TransactionService;
import com.jorleong.onlinebanking.validation.TransactionValidator;

@Controller
@RequestMapping(value="/t")
public class TransactionController {
	@Autowired
	@Qualifier(value="accountServiceImpl")
	AccountService accountService;
	
	@Autowired
	@Qualifier(value="transactionServiceImpl")
	TransactionService transactionService;
	
	@Autowired
	TransactionValidator transactionValidator ;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(transactionValidator);
	}
	
	@PostMapping(value="/saveTransfer")//modelattribute grabs all the html informarion //Model model
	public String saveAccount(@Valid @ModelAttribute ("transaction") Transaction transaction,
			BindingResult result) {
		System.out.println("result.hasErrors(): "+ result.hasErrors());
		if(result.hasErrors()){
			System.out.println("returning to accountForm.jsp");
			return "transferMoney";
		}else{
			Random random = new Random();
			transaction.setId(random.nextLong());
			Calendar today = Calendar.getInstance();
			transaction.setTxDate(today.getTime());
			
			accountService.withdrawById(transaction.getFromAcc(), transaction.getAccTx());
			accountService.depositById(transaction.getToAcc(), transaction.getAccTx());
			transactionService.save(transaction);
			//model.addAttribute("account", acc);
			System.out.println("returning to success.jsp, result.hasErrors():" + result.hasErrors());
			return "success";
		}
	}
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/transfer")
	public String accountForm(Transaction transaction, Model model) {
		return "transferMoney";
	}
	
	
	
}
