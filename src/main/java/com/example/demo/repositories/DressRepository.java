package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Dress;


@Repository
public interface DressRepository extends JpaRepository<Dress,String>{

	
	public List<Dress> findAll();

	public Dress findDressById(String DressId);

	public void deleteById(int id);
	
}
