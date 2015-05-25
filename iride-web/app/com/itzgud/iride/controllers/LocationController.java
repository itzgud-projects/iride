package com.itzgud.iride.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itzgud.iride.services.LocationService;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

@Component
public class LocationController extends Controller {
	
	@Autowired
	LocationService locationService;
	
	@Transactional
	public Result getAllLocations(){
		return ok(Json.toJson(locationService.getAllLocations()));
	}
	
	@Transactional
	public Result getLocation(int locationId){
		return ok(Json.toJson(locationService.getLocation(locationId)));
	}

}
