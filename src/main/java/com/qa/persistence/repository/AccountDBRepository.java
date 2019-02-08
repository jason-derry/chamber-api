package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.business.service.AccountService;
import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Weapon;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}
	
	@Override
	public String getAccount(Long id) {
		return util.getJSONForObject(findAccount(id));
	}
	

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String accout) {
		Account anAccount = util.getObjectForJSON(accout, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String amendAccount(Long id, String account) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			Account changes = util.getObjectForJSON(account, Account.class);
			accountInDB.setUsername(changes.getUsername());
			accountInDB.setPassword(changes.getPassword());
			accountInDB.setEmail(changes.getEmail());
			accountInDB.setCash(changes.getCash());
		}
		return "{\"message\": \"account has been sucessfully amended\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String addWepToAcc(Long user_id, Long weapon_id) {
		String query = "Insert into ACCOUNTWEAPON values (?,?)";
		manager.createNativeQuery(query)
				.setParameter(1, user_id)
				.setParameter(2, weapon_id)
				.executeUpdate();
		return "weapon added to account " + user_id;
	}
	
	@Override
	public String remWepFromAcc(Long user_id, Long weapon_id) {
		// TODO Auto-generated method stub
		return null;
	}

	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
