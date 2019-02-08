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

import com.qa.persistence.domain.Account;
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
		return "account sucessfully added";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "account sucessfully deleted";
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
		return "accountsucessfully amended";
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
	@Transactional(REQUIRED)
	public String remWepFromAcc(Long user_id, Long weapon_id) {
		Query query = manager.createNativeQuery("DELETE FROM ACCOUNTWEAPON WHERE user_id = " + user_id + " AND weapon_id = " + weapon_id);
		query.executeUpdate();
		return "weapon removed from account " + user_id;
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
