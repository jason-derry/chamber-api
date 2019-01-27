package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();
	
	String getAccount(Long id);
	
	String createAccount(String account);
	
	String deleteAccount(Long id);
	
	String amendAccount(Long id, String account);

}