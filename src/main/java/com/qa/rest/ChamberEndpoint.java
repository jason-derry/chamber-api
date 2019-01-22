package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.qa.business.service.WeaponService;

@Path("/chamber")
public class ChamberEndpoint {
	
	@Inject
	private WeaponService wService;
	
	@Path("/weapons")
	@GET
	@Produces({ "application/json" })
	public String getWeapons(@QueryParam("type") String type) {
		return type != null ? wService.getWeapons(type)
                			: wService.getWeapons();
	}	
	
	public void setService(WeaponService service) {
		this.wService = service;
	}

}
