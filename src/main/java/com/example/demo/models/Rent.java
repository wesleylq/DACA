package com.example.demo.models;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Rent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;	
	@ManyToOne
	//@JsonManagedReference
    @JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	@ManyToOne
	//@JsonManagedReference
    @JoinColumn(name = "dress_id", referencedColumnName = "id")
	private Dress dress;
	
	private String dateInit;
	private String dateEnd;
	
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

	public LocalDate getDateInit() {
		return LocalDate.parse(dateInit);
	}

	public void setDateInit(String dateInit) {
		this.dateInit = dateInit;
	}

	public LocalDate getDateEnd() {
		return LocalDate.parse(dateEnd);
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	
	

}
