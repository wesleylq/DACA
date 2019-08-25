package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/clients")
	public List<Client> getClients(){
		return clientService.getClients();
	}
	
	@RequestMapping("/clients/{id}")
	public Client getClients(@PathVariable String id){
		return clientService.getClient(id);
	}
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
    public void addRent(@RequestBody Client client) {
		clientService.addClient(client);
    }
    
    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public void deleteArtista(@PathVariable String id) {
    	clientService.deleteClient(id);
    }

}
