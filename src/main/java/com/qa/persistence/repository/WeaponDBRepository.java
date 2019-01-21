package com.qa.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.persistence.domain.Weapon;
import com.qa.util.JSONUtil;

@Default
public class WeaponDBRepository implements WeaponRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public String getWeapons() {
		Query query = manager.createQuery("Select c FROM Weapon c");
		Collection<Weapon> result = (Collection<Weapon>) query.getResultList();
		return util.getJSONForObject(result);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}