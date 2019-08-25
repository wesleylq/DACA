package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Rent;
import com.example.demo.services.RentService;

@RestController
public class RentController {
	
	@Autowired
	private RentService rentService;
	
	@RequestMapping("/rents")
	public List<Rent> getRents(){
		return rentService.getRents();
	}
	
	@RequestMapping("/rents/{id}")
	public Rent getRent(@PathVariable String id){
		return rentService.getRent(id);
	}

	@RequestMapping(value = "/rents", method = RequestMethod.POST)
    public void addRent(@RequestBody Rent rent) {
    	rentService.addArtista(rent);
    }
    
    @RequestMapping(value = "/rents/{id}", method = RequestMethod.DELETE)
    public void deleteArtista(@PathVariable String id) {
    	rentService.deleteRent(id);
    }
}
