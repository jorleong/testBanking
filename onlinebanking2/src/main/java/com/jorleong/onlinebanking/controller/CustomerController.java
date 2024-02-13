package com.jorleong.onlinebanking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jorleong.onlinebanking.domain.Customer;
import com.jorleong.onlinebanking.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value="saveCustomer")
	public String saveCustomer(@ModelAttribute @Valid Customer customer, BindingResult result) {
		System.out.println("result.hasErrors(): "+ result.hasErrors());
		
		if(result.hasErrors()){
			System.out.println("returning to accountForm.jsp");
			return "customer";
		}else{
			customerService.save(customer);
			//model.addAttribute("account", acc);
			System.out.println("returning to success.jsp, result.hasErrors():" + result.hasErrors());
			return "success";
		}
		
	}
	
	@GetMapping(value="/customer")
	public String createCustomer(Model model, Customer customer) {
		return "customer";
	}
	
}
