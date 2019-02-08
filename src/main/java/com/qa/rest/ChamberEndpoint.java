package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	public String getWeapon(@PathParam("id") Long id) {
		return wService.getWeapon(id);
	}
	
	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return aService.getAllAccounts();
	}
	
	@Path("/getAccount/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAccount(@PathParam("id") Long id) {
		return aService.getAccount(id);
	}
	
	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return aService.addAccount(account);
	}
	
	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return aService.deleteAccount(id);
	}
	
	@Path("/amendAccount/{id}")
	@PUT
	@Produces({ "application/json" })
	public String amendAccount(@PathParam("id") Long id, String account) {
		return aService.amendAccount(id, account);
	}
	
	@Path("/addWepToAcc/{uid}/{wid}")
	@POST
	@Produces({ "application/json" })
	public String addWepToAcc(@PathParam("uid") Long user_id, @PathParam("wid") Long weapon_id) {
		return aService.addWepToAcc(user_id, weapon_id);
	}
	
	@Path("/remWepFromAcc/{uid}/{wid}")
	@DELETE
	@Produces({ "application/json" })
	public String remWepFromAcc(@PathParam("uid") Long user_id, @PathParam("wid") Long weapon_id) {
		return aService.remWepFromAcc(user_id, weapon_id);
	}
	
	public void setService(WeaponService service) {
		this.wService = service;
	}

}
