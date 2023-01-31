package com.byto.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="PlaneTicket")
public class PlaneTicket implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String gender;

	@OneToOne(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
	@JoinColumn(name="expeditionId" , referencedColumnName = "ID")
	private FlightExpedition flightExpedition;
	
	@OneToOne(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
	@JoinColumn(name="userId" , referencedColumnName = "ID")
	private User user;

	
	
	public PlaneTicket() {
		super();
	}
	

	public PlaneTicket(Long id, String gender, FlightExpedition flightExpedition, User user) {
		super();
		this.id = id;
		this.gender = gender;
		this.flightExpedition = flightExpedition;
		this.user = user;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public FlightExpedition getFlightExpedition() {
		return flightExpedition;
	}

	@Transactional
	public void setFlightExpedition(FlightExpedition flightExpedition) {
		this.flightExpedition = flightExpedition;
	}


	public User getUser() {
		return user;
	}

	@Transactional
	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "PlaneTicket [id=" + id + ", gender=" + gender + ", flightExpedition=" + flightExpedition + ", user="
				+ user + "]";
	}	


}
