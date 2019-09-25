package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Dress;
import com.example.demo.repositories.DressRepository;


@Service
@Transactional
public class DressService {
	
	@Autowired
	private DressRepository dressRepository;

	public List<Dress> getDresses() {
		return dressRepository.findAll();
	}

	public Dress getDress(String id) {
		return dressRepository.findDressById(id);
	}

	public void addArtista(Dress dress) {
		dressRepository.save(dress);
		
	}

	public void deleteRent(int id) {
		dressRepository.deleteById(id);
		
	}
}
