package com.jorleong.onlinebanking.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jorleong.onlinebanking.domain.Account;
import com.jorleong.onlinebanking.domain.Transaction;
import com.jorleong.onlinebanking.service.AccountService;
import com.jorleong.onlinebanking.service.BranchService;
import com.jorleong.onlinebanking.service.MailService;
import com.jorleong.onlinebanking.service.TransactionService;
import com.jorleong.onlinebanking.service.UserService;
import com.jorleong.onlinebanking.validation.AccountValidator;

//this is trhe spring implementation of restful services
@Controller
//@Scope(value="sesion")
public class AccountController {
	
	@Autowired
	MailService mailService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	@Qualifier(value="accountServiceImpl")
	AccountService accountService;
	
	@Autowired
	AccountValidator accountValidator;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	BranchService branchService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(accountValidator);
	}
	
	@PostMapping(value="/saveAccountForm")//modelattribute grabs all the html information
	public String saveAccount(@Valid @ModelAttribute ("account") Account acc,
			BindingResult result) {
		System.out.println("result.hasErrors(): "+ result.hasErrors());
		
		if(result.hasErrors()){
			System.out.println("returning to accountForm.jsp");
			return "accountForm";
		}else{
			Calendar today = Calendar.getInstance();
			acc.setOpenDate(today.getTime());
			//model.addAttribute("account", acc);
			System.out.println("returning to success.jsp, result.hasErrors():" + result.hasErrors());
			
			acc.setBranch(branchService.getById(1));
			acc.setUser(userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
			accountService.save(acc);
			
			return "success";
		}
	}
	
	@GetMapping(value="/createAccount")
	public String accountForm(Account account,Model model) {
		List<String> accountTypes = new ArrayList<>();
		accountTypes.add("Checkings");
		accountTypes.add("Savings");
		accountTypes.add("Transactional");
		accountTypes.add("Dividend");
		accountTypes.add("CD (Certificate of Deposit)");
		accountTypes.add("Individual Retirement Account");
		model.addAttribute("AccountTypes",accountTypes);
		
//		String subject = "testing mail Service";
//		String body = accountTypes.get(0);
//		String body1 = accountTypes.get(1);
//		String body2 = accountTypes.get(2);
//		String body4 = "" + body + " " + body1 +" " + body2;
//		String mailTo = "jorleong@gmail.com";
//		mailService.sendMail(mailTo, subject, body4);
		
		return "accountForm";
	}
	
	@GetMapping(value="/deposit")
	public String accountDeposit(Account account, Long accNo, Double accBalance) {
		return "accountDeposit";
	}
	@GetMapping(value="/withdraw")
	public String accountWithdraw(Account account, Long accNo, Double accBalance) {
		return "accountWithdraw";
	}
	
	@GetMapping(value="/accountDeposit")//modelattribute grabs all the html information
	public String accountDeposit(@Valid @RequestParam long accNo,
			@Valid @RequestParam double accBalance, @ModelAttribute ("account") Account acc ,BindingResult result) {
		
		System.out.println("result.hasErrors(): "+ result.hasErrors());
		if(result.hasErrors()){
			System.out.println("returning to accountForm.jsp");
			return "accountDeposit";
		}else{
			accountService.depositById(accNo, accBalance);
			AccountDepositWithdraw(accNo, accBalance);
			//model.addAttribute("account", acc);
			return "success";
		}
	}
	@GetMapping(value="/accountWithdraw")//modelattribute grabs all the html information
	public String accountWithdraw(@Valid @RequestParam long accNo,
			@Valid @RequestParam double accBalance, @ModelAttribute ("account") Account acc 
			,BindingResult result) {
		
		System.out.println("result.hasErrors(): "+ result.hasErrors());
		if(result.hasErrors()){
			System.out.println("returning to accountForm.jsp");
			return "accountDeposit";
		}else{
//			System.out.println("USER FROM SESSION ATTRIBUTE: " + user);
			accountService.withdrawById(accNo, accBalance);
			AccountDepositWithdraw(accNo, accBalance*-1);
			//model.addAttribute("account", acc);
			return "success";
		}
		
	}
	
	public void AccountDepositWithdraw(long accNo1, double depositWithdrawAmount) {
		Transaction transaction = new Transaction();
		
		Random random = new Random();
		transaction.setId(random.nextLong());
		Calendar today = Calendar.getInstance();
		transaction.setTxDate(today.getTime());
		
		transaction.setAccTx(depositWithdrawAmount);
		transaction.setId(random.nextLong());
		transaction.setToAcc(accNo1);
		transaction.setFromAcc(accNo1);
		if(depositWithdrawAmount<=0) transaction.setComments("Withdrew: " + depositWithdrawAmount*-1);
		if(depositWithdrawAmount>0) transaction.setComments("Deposited: " + depositWithdrawAmount);
		transactionService.save(transaction);
	}
	
//	@GetMapping(value="/download/Account")
	@GetMapping(value="/viewAllAccounts/{format}")
	public ModelAndView viewAllAccounts(@PathVariable String format) {
		List<Account> accountList = accountService.findAll();
		if(format.equals("normal")) {
			return new ModelAndView("viewAllAccounts", "accountList", accountList);
		}
		else if(format.equals("pdf")) {
			return new ModelAndView("accountListPdf", "accountList", accountList);
		}
		else if(format.equals("csv")) {
			return new ModelAndView("accountCsvView", "accountList", accountList);
		}
		else if(format.equals("excel")) {
			return new ModelAndView("accountExcelView", "accountList", accountList);
		}
		return null;
		
	}
	
	@GetMapping(value="/sendMail")
	public String sendingMailForm() {
		String subject = "testing mail Service";
		String body = "testing Mail Service";
		String mailTo = "jorleong@gmail.com";
		mailService.sendMail(mailTo, subject, body);
		return "success";
		
	}
	
	
	
}
