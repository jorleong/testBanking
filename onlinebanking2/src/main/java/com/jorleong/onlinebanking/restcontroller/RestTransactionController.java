package com.jorleong.onlinebanking.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jorleong.onlinebanking.domain.Transaction;
import com.jorleong.onlinebanking.service.TransactionService;

@Controller
@RequestMapping(value="/t")
public class RestTransactionController {
	@Autowired
	@Qualifier(value="transactionServiceImpl")
	TransactionService transactionService;
	
	@GetMapping(value="/viewTransactions")
	public ModelAndView viewAllTransactions(Transaction transactions, ModelAndView model){
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList = transactionService.findAll();
		model.addObject(transactionList);
		model.setViewName("viewTransactions");
		return model;
		
	}
	@GetMapping(value="/viewOneTransaction")
	public ModelAndView viewOneTransaction(Transaction transactions, ModelAndView model){
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList = transactionService.findAll();
		model.addObject(transactionList);
		model.setViewName("viewTransactions");
		return model;
		
	}
}
