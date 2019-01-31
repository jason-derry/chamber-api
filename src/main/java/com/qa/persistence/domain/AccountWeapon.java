package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountWeapon {

	@Id
	private Long user_id;
	@Id
	private Long weapon_id;

	public AccountWeapon() {
	}

	public AccountWeapon(Long user_id, Long weapon_id) {
		this.user_id = user_id;
		this.weapon_id = weapon_id;
	}

}