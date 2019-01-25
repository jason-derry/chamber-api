package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.qa.business.service.AccountService;
import com.qa.business.service.WeaponService;

@Path("/chamber")
public class ChamberEndpoint {
	
	@Inject
	private WeaponService wService;
	
	@Inject
	private AccountService aService;
	
	@Path("/weapons")
	@GET
	@Produces({ "application/json" })
	public String getWeapons(@QueryParam("type") String type) {
		return type != null ? wService.getWeapons(type)
                			: wService.getWeapons();
	}
	
	@Path("/weapons/{id}")
	@GET
	@Produces({ "application/json" })
	public String getWeapon(@QueryParam("id") Long id) {
		return wService.getWeapon(id);
	}
	
	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return aService.getAllAccounts();
	}
	
	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return aService.addAccount(account);
	}
	
	public void setService(WeaponService service) {
		this.wService = service;
	}

}
