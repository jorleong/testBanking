package com.jorleong.onlinebanking.controller;

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

import com.jorleong.onlinebanking.domain.Branch;
import com.jorleong.onlinebanking.service.BranchService;
import com.jorleong.onlinebanking.validation.BranchValidator;

@Controller
@RequestMapping(value="/b")
public class BranchController {
	
	@Autowired
	@Qualifier(value="branchServiceImpl")
	BranchService branchService;
	
	@Autowired
	BranchValidator branchValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(branchValidator);
	}
	
	@PostMapping(value="/saveBranchForm")//modelattribute grabs all the html informarion
	public String saveAccount(@Valid @ModelAttribute ("branch") Branch branch,  BindingResult result) {
		System.out.println("result.hasErrors(): "+ result.hasErrors());
		if(result.hasErrors()){
			System.out.println("returning to branchForm.jsp");
			return "branchForm";
		}else{
			branchService.save(branch);
			//model.addAttribute("account", acc);
			System.out.println("returning to success.jsp, result.hasErrors():" + result.hasErrors());
			return "success";
		}
	}
	
	@GetMapping(value="/createBranch")
	public String accountForm(Branch branch,Model model) {
		return "branchForm";
	}
}
