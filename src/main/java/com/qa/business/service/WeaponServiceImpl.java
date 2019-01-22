package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.WeaponRepository;

public class WeaponServiceImpl implements WeaponService {
	
	@Inject
	private WeaponRepository repo;

	@Override
	public String getWeapons() {
		return repo.getWeapons();		
	}
	
	public void setRepo(WeaponRepository repo) {
		this.repo = repo;
	}

}
