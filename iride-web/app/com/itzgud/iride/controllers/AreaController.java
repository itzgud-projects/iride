package com.itzgud.iride.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itzgud.iride.services.AreaService;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

@Component
public class AreaController extends Controller {

	@Autowired
	private AreaService areaService;
	
	@Transactional
	public Result getAllArea(){
		return ok(Json.toJson(areaService.getAllAreas()));
	}
	
	@Transactional
	public Result getArea(int areaId){
		return ok(Json.toJson(areaService.getArea(areaId)));
	}
	
	@Transactional
	public Result getAreabyLocation(int locationId){
		return ok(Json.toJson(areaService.getAreaByLocation(locationId)));
	}
}
