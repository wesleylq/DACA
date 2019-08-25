package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client,String>{

	
	public List<Client> findAll();

	public Client findClientById(String clientId);
	
}
