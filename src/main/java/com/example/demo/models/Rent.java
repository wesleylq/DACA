package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Rent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;	
	@OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	@OneToOne
    @JoinColumn(name = "dress_id", referencedColumnName = "id")
	private Dress dress;
	
	public Rent() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Dress getDress() {
		return dress;
	}
	public void setDress(Dress dress) {
		this.dress = dress;
	}
	

}
