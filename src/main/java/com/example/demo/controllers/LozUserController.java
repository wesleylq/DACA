package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.LozUser;
import com.example.demo.services.LozUserService;

@RestController
public class LozUserController {
	
	@Autowired
	private LozUserService clientService;	
	
	@RequestMapping("/clients")
	public List<LozUser> getClients(){
		return clientService.getClients();
	}
	
	@RequestMapping("/clients/{id}")
	public LozUser getClients(@PathVariable String id){
		return clientService.getClient(id);
	}
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ResponseEntity<LozUser> addClient(@RequestBody LozUser client) {
		
		if(!this.checkClient(client.getName())) {			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null); 
		}
		clientService.addClient(client);
    	return ResponseEntity.status(HttpStatus.OK).body(client); 
				
    }
    
    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    public void deleteArtista(@PathVariable int id) {
    	clientService.deleteClient(id);
    }  
    

    public boolean checkClient(String clientName) {	
    	
    	for (LozUser client : clientService.getClients() ) {
    		if(client.getName().equals(clientName)) {
    			return false;
    		}
    	}
    	return true;
    }

}
