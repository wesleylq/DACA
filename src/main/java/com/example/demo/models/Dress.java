package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Dress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String model;
	//private String value;
	@OneToOne(mappedBy = "dress")
	private Rent rent;
	
	
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

	public Rent getRent() {
		return rent;
	}


	public void setRent(Rent rent) {
		this.rent = rent;
	}
	
	
}
