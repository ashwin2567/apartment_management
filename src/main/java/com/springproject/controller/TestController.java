package com.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = {"/api/clients", "/api/clients/{optionalClientId}"})
	List<Client> getAllClients(
	        @PathVariable(required = false, name = "optionalClientId") String optionalClientId
	) {
	    return apartmentService.findClients(optionalClientId);
	}
	
	@GetMapping(value = "/api/apartments")
    List<ClientApartment> getAllApartments(
            @RequestParam(required = false, name = "city") String city,
            @RequestParam(required = false, name = "minPrice") Integer minPrice,
            @RequestParam(required = false, name = "maxPrice") Integer maxPrice,
            @RequestParam(required = false, name = "isAvailableForRent") Boolean isAvailableForRent
    ) {
        return apartmentService.findApartments(city, minPrice, maxPrice, isAvailableForRent);
    }
	
	@PostMapping(value = "/api/client")
	String createClient(@RequestBody ClientRequest clientRequest) {
	    return apartmentService.createClient(clientRequest).toString();
	}
	
}
