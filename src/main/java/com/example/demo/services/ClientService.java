package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	public Client getClient(String id) {
		return clientRepository.findClientById(id);
	}
	
	public void addClient(Client client) {
		clientRepository.save(client);
		
	}

	public void deleteClient(String id) {
		clientRepository.deleteById(id);
		
	}

	
}
