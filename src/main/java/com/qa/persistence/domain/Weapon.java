package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weapon {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String name;
	private String type;
	private String ammo;
	private Double weight;
	private Integer magSize;
	private Double reloadSpd;
	private Long rof;
	private Long range;
	private Long damage;
	private Double accMod;
	private Double critMod;
	
	public Weapon() {
	}
	
	public Weapon(String name, String type, String ammo, Double weight, Integer magSize, Double reloadSpd, Long rof, Long range, Long damage, Double accMod, Double critMod ) {
		this.name = name;
		this.type = type;
		this.ammo = ammo;
		this.weight = weight;
		this.magSize = magSize;
		this.reloadSpd = reloadSpd;
		this.rof = rof;
		this.range = range;
		this.damage = damage;
		this.accMod = accMod;
		this.critMod = critMod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAmmo() {
		return ammo;
	}

	public void setAmmo(String ammo) {
		this.ammo = ammo;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getMagSize() {
		return magSize;
	}

	public void setMagSize(Integer magSize) {
		this.magSize = magSize;
	}

	public Double getReloadSpd() {
		return reloadSpd;
	}

	public void setReloadSpd(Double reloadSpd) {
		this.reloadSpd = reloadSpd;
	}

	public Long getRof() {
		return rof;
	}

	public void setRof(Long rof) {
		this.rof = rof;
	}

	public Long getRange() {
		return range;
	}

	public void setRange(Long range) {
		this.range = range;
	}

	public Long getDamage() {
		return damage;
	}

	public void setDamage(Long damage) {
		this.damage = damage;
	}

	public Double getAccMod() {
		return accMod;
	}

	public void setAccMod(Double accMod) {
		this.accMod = accMod;
	}

	public Double getCritMod() {
		return critMod;
	}

	public void setCritMod(Double critMod) {
		this.critMod = critMod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
