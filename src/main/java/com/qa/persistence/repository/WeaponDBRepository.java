package com.qa.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Weapon;
import com.qa.util.JSONUtil;

@Default
public class WeaponDBRepository implements WeaponRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getWeapons() {
		Query query = manager.createQuery("Select w FROM Weapon w");
		Collection<Weapon> result = (Collection<Weapon>) query.getResultList();
		return util.getJSONForObject(result);
	}
	
	@Override
	public String getWeapons(String type) {
		Query query = manager.createQuery("Select w FROM Weapon w WHERE w.type = :type"); 
		query.setParameter("type", type);
		Collection<Weapon> result = (Collection<Weapon>) query.getResultList();
		return util.getJSONForObject(result);
	}
	
	@Override
	public String getWeapon(Long id) {
		return util.getJSONForObject(findWeapon(id));
	}
	
	private Weapon findWeapon(Long id) {
		return manager.find(Weapon.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}