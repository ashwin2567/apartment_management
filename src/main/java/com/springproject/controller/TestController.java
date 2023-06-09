package com.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.entity.Client;
import com.springproject.entity.ClientApartment;
import com.springproject.service.ApartmentService;

@RestController
public class TestController {
	
	@Autowired
	private ApartmentService apartmentService;
	
	@GetMapping(value = "/hello")
	String hello() {
		return "Application is working.";
	}
	
	@GetMapping(value = "/api/clients")
	List<Client> getAllClients(){
		return apartmentService.getAllClients();
	}
	
	@GetMapping(value = "/api/apartments")
	List<ClientApartment> getAllApartments(){
		return apartmentService.getAllApartments();
	}
	
}
