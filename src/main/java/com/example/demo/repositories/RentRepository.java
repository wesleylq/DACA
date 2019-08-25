package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Rent;


@Repository
public interface RentRepository extends JpaRepository<Rent,String>{

	
	public List<Rent> findAll();

	public Rent findRentById(String RentId);
	
}
