package com.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.entity.Client;
import com.springproject.entity.ClientApartment;
import com.springproject.repository.ClientApartmentRepository;
import com.springproject.repository.ClientRepository;

@Service
public class ApartmentService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientApartmentRepository clientApartmentRepository;
	
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	
	public List<ClientApartment> getAllApartments(){
		return clientApartmentRepository.findAll();
	}
}
