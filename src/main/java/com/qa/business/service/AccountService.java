package com.qa.business.service;

public interface AccountService {

	String getAllAccounts();
	
	String getAccount(Long id);

	String addAccount(String account);

	String deleteAccount(Long id);
	
	String amendAccount(Long id, String account);
	
	String addWepToAcc(Long user_id, Long weapon_id);
	
	String remWepFromAcc(Long user_id, Long weapon_id);

}