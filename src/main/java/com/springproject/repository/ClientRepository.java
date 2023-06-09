package com.springproject.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.entity.Client;

public interface ClientRepository extends JpaRepository<Client, UUID>{

}
