package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Rent> addRent(@RequestBody Rent rent) {
		
		if((!this.checkRent(rent.getDress().getId(),rent.getDateInit(), rent.getDateEnd()))
				|| rent.getDateInit().isAfter(rent.getDateEnd())) {			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null); 
		}
    	rentService.addRent(rent);
    	return ResponseEntity.status(HttpStatus.OK).body(rent); 
    }
    
    @RequestMapping(value = "/rent/{id}", method = RequestMethod.DELETE)
    public void deleteArtista(@PathVariable int id) {
    	rentService.deleteRent(id);
    }
    

	public boolean checkRent(int dressId, LocalDate dateInit, LocalDate dateEnd) {	
		
		for (Rent  rent : rentService.getRents() ) {
			if(rent.getDress().getId() == dressId &&
					(
							(dateInit.isAfter(rent.getDateInit()) && dateInit.isBefore(rent.getDateEnd())) ||
							(dateEnd.isAfter(rent.getDateInit()) && dateEnd.isBefore(rent.getDateEnd())) ||
							(dateEnd.isEqual(rent.getDateInit()) || dateEnd.isEqual(rent.getDateEnd()) || 
							dateInit.isEqual(rent.getDateInit()) || dateInit.isEqual(rent.getDateEnd())) 
					) 
			){
				return false;
			}
		}
		return true;
	}
	
    
}


