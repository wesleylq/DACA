package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Rent;
import com.example.demo.repositories.RentRepository;


@Service
public class RentService {
	
	@Autowired
	private RentRepository rentRepository;

	public List<Rent> getRents() {
		return rentRepository.findAll();
	}

	public Rent getRent(String id) {
		return rentRepository.findRentById(id);
	}

	public void addRent(Rent rent) {
		rentRepository.save(rent);
		
	}

	public void deleteRent(String rentId) {
		rentRepository.deleteById(rentId);
		
	}
}
