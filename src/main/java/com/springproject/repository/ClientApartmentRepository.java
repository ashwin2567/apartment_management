package com.springproject.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springproject.entity.ClientApartment;

public interface ClientApartmentRepository extends JpaRepository<ClientApartment, UUID>,
JpaSpecificationExecutor<ClientApartment>{

}
