package com.jorleong.onlinebanking.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.transaction.Transactional;

@WebService(name="AccountWebService")
public interface AccountWebService {
	@WebMethod
	public DepositResponse deposit(DepositRequest depositrequest);
		
	@WebMethod
	public AccountResponse2 getAccountdetails(AccountRequest2 accountrequest);

	@WebMethod
	public TransferResponse transferMoney(TransferRequest request);
	
	@WebMethod
	@Transactional
	public AccountResponse createAccount(AccountRequest accountRequest);
	
}
