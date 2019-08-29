package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Dress;
import com.example.demo.services.DressService;

@RestController
public class DressController {
	
	@Autowired
	private DressService dressService;
	
	@RequestMapping("/dresses")
	public List<Dress> getCDresses(){
		return dressService.getDresses();
	}
	
	@RequestMapping("/dresses/{id}")
	public Dress getClients(@PathVariable String id){
		return dressService.getDress(id);
	}
	
	@RequestMapping(value = "/dresses", method = RequestMethod.POST)
    public void addRent(@RequestBody Dress dress) {
    	dressService.addArtista(dress);
    }
    
    @RequestMapping(value = "/dress/{id}", method = RequestMethod.DELETE)
    public void deleteArtista(@PathVariable int id) {
    	dressService.deleteRent(id);
    }

}
