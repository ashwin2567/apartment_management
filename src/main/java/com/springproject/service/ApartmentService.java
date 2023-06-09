package com.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.entity.Client;
import com.springproject.entity.ClientApartment;
import com.springproject.repository.ClientApartmentRepository;
import com.springproject.repository.ClientRepository;

import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;
import static com.springproject.repository.ClientApartmentSpecification.*;

@Service
public class ApartmentService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientApartmentRepository clientApartmentRepository;
	/*
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	
	public List<ClientApartment> getAllApartments(){
		return clientApartmentRepository.findAll();
	}
	*/
	public List<Client> findClients(String optionalClientId) {
	    if (optionalClientId != null) {
	        var clientIds = List.of(
	                UUID.fromString(optionalClientId)
	        );
	 
	        return clientRepository.findAllById(clientIds);
	    } else {
	        return clientRepository.findAll();
	    }
	}
	
	public List<ClientApartment> findApartments(
	        String city, Integer minPrice, Integer maxPrice, Boolean isAvailableForRent) {
	    
	    Specification<ClientApartment> specification = Specification.where(null);
	 
	    if (city != null) {
	        specification = specification.and(cityContainsIgnoreCase(city));
	    }
	 
	    if (minPrice != null && maxPrice != null) {
	        specification = specification.and(rentPriceBetween(minPrice, maxPrice));
	    }
	 
	    if (isAvailableForRent != null) {
	        specification = specification.and(isAvailableForRent(isAvailableForRent));
	    }
	 
	    return clientApartmentRepository.findAll(specification);
	}
}
