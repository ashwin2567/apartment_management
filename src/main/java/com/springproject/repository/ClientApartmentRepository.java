package com.springproject.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.entity.ClientApartment;

public interface ClientApartmentRepository extends JpaRepository<ClientApartment, UUID>{

}
