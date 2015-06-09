package com.itzgud.iride.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itzgud.iride.services.CustomerService;

import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

@Component
public class CustomerController extends Controller{

	@Autowired
	CustomerService customerService;
	
	@Transactional
	public Result getAllCustomers(){
		return ok(Json.toJson(customerService.getAllCustomers()));
	}
	
}
