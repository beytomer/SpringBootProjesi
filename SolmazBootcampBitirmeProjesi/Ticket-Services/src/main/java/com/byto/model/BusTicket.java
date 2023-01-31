package com.byto.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="BusTicket")
public class BusTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String gender;
	
	@OneToOne(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
	@JoinColumn(name="expeditionId" , referencedColumnName = "ID")
	private BusExpedition busExpedition;
	
	
	@OneToOne(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName = "ID" )
	private User user;
	
	
	public BusTicket() {
		super();
	}

	public BusTicket(Long id, String gender, BusExpedition busExpedition, User user) {
		super();
		this.id = id;
		this.gender = gender;
		this.busExpedition = busExpedition;
		this.user = user;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public BusExpedition getBusExpedition() {
		return busExpedition;
	}

	public void setBusExpedition(BusExpedition busExpedition) {
		this.busExpedition = busExpedition;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	
}
