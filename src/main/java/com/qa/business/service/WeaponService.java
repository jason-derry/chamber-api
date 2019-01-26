package com.qa.business.service;

public interface WeaponService {
	
	String getWeapons();

	String getWeapons(String type);
	
	String getWeapon(Long id);

}
