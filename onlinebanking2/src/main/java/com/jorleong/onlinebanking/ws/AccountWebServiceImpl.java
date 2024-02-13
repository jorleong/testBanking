package com.jorleong.onlinebanking.ws;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorleong.onlinebanking.domain.Account;
import com.jorleong.onlinebanking.domain.Branch;
import com.jorleong.onlinebanking.service.BranchService;

@Transactional
@Service(value = "accountWebServiceImpl")
public class AccountWebServiceImpl implements AccountWebService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	BranchService branchService;

//	@Override
//	public DepositResponse deposit(DepositRequest depositrequest) {
//		Account account=accountService.getById(depositrequest.getAccountId());
//		account.setAccBalance(account.getAccBalance()+depositrequest.getAmount());
//		accountService.save(account);
//		
//		DepositResponse response=new DepositResponse();
//		response.setMessage(depositrequest.getAmount()+" @ deposited in account"+account.getAccno());
//		return response;
//	}

	@Override
	public DepositResponse deposit(DepositRequest depositrequest) {
		System.out.println("######" + depositrequest.getAccountId());
		Account account = getSession().get(Account.class, depositrequest.getAccountId());
		double balance = account.getAccBalance() + depositrequest.getAmount();
		System.out.println("new balance is" + balance);
		account.setAccBalance(balance);
		getSession().persist(account);

		DepositResponse response = new DepositResponse();
		response.setAccBalance(balance);
		response.setAccno(depositrequest.getAccountId());

		return response;
	}
	
	public AccountResponse2 getAccountdetails(AccountRequest2 accountrequest) {
		System.out.println("#######" + accountrequest.getAccno());
		Account account = getSession().get(Account.class, accountrequest.getAccno());
		System.out.println("account details from getAccountdetails method" + account);
		AccountResponse2 accountresponse = new AccountResponse2();
		accountresponse.setAccholdername(account.getAccHolderName());
		accountresponse.setAccno(account.getAccNo());
		accountresponse.setAccType(account.getAccType());
		accountresponse.setAccBalance(account.getAccBalance());
		return accountresponse;

	}

	@Override
	public TransferResponse transferMoney(TransferRequest request) {
		System.out.println("amount" + request.getTransferAmount());
		System.out.println("toAcc" + request.getToAcc());
		System.out.println("fromAcc" + request.getFromAcc());
		
		Account fromAccount = getSession().get(Account.class, request.getFromAcc());
		Account ToAccount = getSession().get(Account.class, request.getToAcc());
		
		double fromBalance = fromAccount.getAccBalance() - request.getTransferAmount();
		double toBalance = ToAccount.getAccBalance() + request.getTransferAmount();
		
		fromAccount.setAccBalance(fromBalance);
		ToAccount.setAccBalance(toBalance);
		getSession().persist(fromAccount);
		getSession().persist(ToAccount);

		TransferResponse transferResponse = new TransferResponse();
		transferResponse.setFromAcc(request.getFromAcc());
		transferResponse.setToAcc(request.getToAcc());
		transferResponse.setFromAccTransferAmount(fromBalance);
		transferResponse.setToAccTransferAmount(toBalance);
		
		return transferResponse;
	}
	
	public AccountResponse createAccount(AccountRequest accountRequest) {
		
		Account account = new Account();
		account.setAccHolderName(accountRequest.getAccHolderName());
		account.setAccType(accountRequest.getAccType());
		account.setAccBalance(accountRequest.getAccBalance());
		account.setOpenDate(accountRequest.getOpenDate());
		
		Branch branch = getSession().get(Branch.class, accountRequest.getbCode());
//		Branch branch = branchService.getById(accountRequest.getbCode());
		account.setBranch(branch);
		
		getSession().merge(account);
//		getSession().getTransaction().commit();
		
		Criteria criteria = getSession().createCriteria(Account.class).setProjection(Projections.max("accNo"));
		Long theAccNo = (Long) criteria.uniqueResult();
		System.out.println("@@@@@@@@@@@@@@@@@@@@" + theAccNo);
		
		AccountResponse accountResponse = new AccountResponse();
		accountResponse.setAccno(theAccNo);
		accountResponse.setAccholdername(account.getAccHolderName());
		accountResponse.setAccType(account.getAccType());
		accountResponse.setAccBalance(account.getAccBalance());
		accountResponse.setOpenDate(account.getOpenDate());
		accountResponse.setBranch(account.getBranch().getbCode());
		
		return accountResponse;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();

	}

}