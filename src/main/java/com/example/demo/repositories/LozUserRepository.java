package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.LozUser;


@Repository
public interface LozUserRepository extends JpaRepository<LozUser,String>{

	
	public List<LozUser> findAll();

	public LozUser findClientById(String clientId);

	public void deleteById(int id);

	public LozUser findByUsername(String s);

	
}
