package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Dress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String model;
	//private String value;
	@JsonBackReference
	@OneToMany(mappedBy = "dress")
	//@JoinColumn(name= "rents")
	private List<Rent> rents;
	
	
	public Dress() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}
/*
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
*/


	public List<Rent> getRents() {
		return rents;
	}


	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	
	
}
