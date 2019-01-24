package com.qa.persistence.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTWEAPON")
public class AccountWeapon implements Serializable {

	@Id
	private Long user_id;
	@Id
	private Long weapon_id;

	@ManyToOne
	@JoinColumn(name = "user_id", updatable = false, insertable = false, referencedColumnName = "id")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "weapon_id", updatable = false, insertable = false, referencedColumnName = "id")
	private Weapon weapon;

	public AccountWeapon() {
	}

	public AccountWeapon(Long user_id, Long weapon_id) {
		this.user_id = user_id;
		this.weapon_id = weapon_id;
	}

}