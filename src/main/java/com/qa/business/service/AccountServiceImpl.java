package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}
	
	@Override
	public String getAccount(Long id) {
		return repo.getAccount(id);
	}

	@Override
	public String addAccount(String account) {
		return repo.createAccount(account);
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}
	
	@Override
	public String amendAccount(Long id, String account) {
		return repo.amendAccount(id, account);
	}
	
	@Override
	public String addWepToAcc(Long user_id, Long weapon_id) {
		return repo.addWepToAcc(user_id, weapon_id);
	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}


}
