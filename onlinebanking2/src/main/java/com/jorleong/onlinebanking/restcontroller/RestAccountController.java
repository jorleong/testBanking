package com.jorleong.onlinebanking.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorleong.onlinebanking.domain.Account;
import com.jorleong.onlinebanking.service.AccountService;


@RestController
@RequestMapping(value="/a")
public class RestAccountController {

	@Autowired
	AccountService accountService;
		
	@GetMapping(value="/getAccount/{id}")
	public ResponseEntity<Account> GetOneAccount(@PathVariable long id){
		Account account = accountService.getById(id);
		
		return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Account>> getAllAccounts(){
		List<Account> listOfAccounts = accountService.findAll();
		return new ResponseEntity<List<Account>>(listOfAccounts, HttpStatus.OK);
	}
	
	@PostMapping(value="/createAccount", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> createAccount(@RequestBody Account account){
		accountService.save(account);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping(value="/findOne/{id}")
	public ResponseEntity<Account> findOne(@PathVariable long id){
		Account account = accountService.getById(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> updateOne(@PathVariable long id) {
		Account account = accountService.getById(id);
		account.setAccBalance(account.getAccBalance() + 2000);
		accountService.save(account);
		return new ResponseEntity<String>(HttpStatus.OK);

	}
	
	@DeleteMapping(value="/delete/{id}")//@RequestParam
	public ResponseEntity<String> deleteAccount(@PathVariable long id){
		accountService.deleteById(id);
		HttpHeaders headers = new HttpHeaders();
//		headers.add("authorization", new String(Base64.encodeBase64String("jordan:jordan123".getBytes())));
//		headers.add("authorization", new String(Base64.("jordan:jordan123".getBytes())));		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping(value="/findByBalance/{accBalance}")
	public ResponseEntity<List<Account>> findOneByBalance(@PathVariable double accBalance){
		List<Account> accounts = accountService.findByBalanceLessThan(accBalance);
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping(value="/create", consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
//			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
//			)
//	public ResponseEntity<String> createEmployee2(@RequestBody Employee e){
//		
//		employeeServiceJpa.save(e);
//		return new ResponseEntity<String>(HttpStatus.OK);
//		
//	}
//	
//	//SoapUI uasge:  Method==> PUT,    Endpoint==> http://localhost:8080     Resource ==> /r/update/13?designation=Analyst&salary=5000
//	//SoapUI uasge: Endpoint==>http://localhost:8080/r/update/13?designation=Analyst&salary=5555
//	//SoapUI uasge: Endpoint==>http://localhost:8080/r/update/13   parameters==>?designation=Sr. Analyst&salary=7500
//		
//	@PutMapping(value="/update/{id}")
//	public ResponseEntity<Employee> update(@PathVariable int id, @RequestParam String designation, @RequestParam int salary){
//		
//		Employee employeeToBeUpdated = employeeServiceJpa.findById(id);
//		employeeToBeUpdated.setSalary(salary);
//		employeeToBeUpdated.setDesignation(designation);
//		
//		employeeServiceJpa.save(employeeToBeUpdated );
//		
//		return new ResponseEntity<Employee> (employeeToBeUpdated , HttpStatus.OK);
//		
//	}
}
