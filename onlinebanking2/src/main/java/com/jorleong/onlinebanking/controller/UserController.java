package com.jorleong.onlinebanking.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jorleong.onlinebanking.domain.Role;
import com.jorleong.onlinebanking.domain.User;
import com.jorleong.onlinebanking.service.UserService;
import com.jorleong.onlinebanking.validation.UserValidator;

@Controller
//@SessionAttributes("user")//allows for global application
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator userValidator;
	
	@GetMapping(value="/register")
	public String register(User user) {
//		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping(value="/register")
	public String saveRegister(@ModelAttribute User user,String roles, Model model , BindingResult result) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "registration";
		}else {
			Role role = new Role();
			role.setId(3);
			Set<Role> setRole = new HashSet<Role>();
			setRole.add(role);
			user.setRoles(setRole);
			userService.save(user);
			
			return "success";
		}
		
	}
	
	@GetMapping(value="/login")
	public String loginPage(Model model,@ModelAttribute("user") User user, String error,String logout
			, HttpServletRequest req, HttpServletResponse res) {
//		model.addAttribute("user", new User());
//		System.out.println("WE ARE LOGGING IN" + user);
		if(error != null) {
			model.addAttribute("error", "Username or password is not correct");
		}
		if(logout != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(authentication!=null) {
				new SecurityContextLogoutHandler().logout(req, res, authentication);
			}
			//return "login";
		}
//		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		return "login";
	}
	
	@GetMapping(value= {"/", "/index", "/welcome","/*"})
	public String welcome(Model model, User user) {
		return "welcome";
	}
	
	@GetMapping(value= {"/login?logout", "/logout", "/login?error"})
	public String logout() {
		return "redirect:/login";
	}
	@GetMapping(value="accessDenied")
	public String denyAccess(Model model) {
		return "accessDenied";
	}
	
	
	public Set<Role> getRoles(){
		Role role1 = new Role(new Long(1), "ADMIN");
		Role role2 = new Role(new Long(2), "DBA");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role1);roles.add(role2);
		return roles;
	}
	
	//create a set of all roles then add as model attribute
	@GetMapping(value="/changeAuthority")
	public String changeAuthority(@Valid @ModelAttribute User user,Model model) {
		model.addAttribute("roles", getRoles());
		return "changeAuthority";
	}
	
	@PostMapping(value="/saveAuthority")
	public String saveAuthority(@Valid @ModelAttribute User user,Model model) {
			model.addAttribute("roles" , getRoles());
			return "welcome";
		
		
	}
	
}
