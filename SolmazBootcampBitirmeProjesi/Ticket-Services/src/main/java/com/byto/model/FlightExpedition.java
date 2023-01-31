package com.byto.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="FlightExpedition")
public class FlightExpedition  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String boardingTime;
	
	private Date date;
	
	private String fromTo;
	
	private String toFrom;
	
	private String flightNo;

	private final int capacity = 189;
	
	public FlightExpedition() {
		super();
	}


	public FlightExpedition(Long id, String boardingTime, Date date, String from, String to, String flightNo			) {
		super();
		this.id = id;
		this.boardingTime = boardingTime;
		this.date = date;
		this.fromTo = from;
		this.toFrom = to;
		this.flightNo = flightNo;
	}

	public int getCapacity() {
		return capacity;
	}

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBoardingTime() {
		return boardingTime;
	}


	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public String getFromTo() {
		return fromTo;
	}

	public void setFromTo(String fromTO) {
		this.fromTo = fromTO;
	}

	public String getToFrom() {
		return toFrom;
	}

	public void setToFrom(String toFrom) {
		this.toFrom = toFrom;
	}


	public String getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}


	@Override
	public String toString() {
		return "FlightExpedition [id=" + id + ", boardingTime=" + boardingTime + ", date=" + date + ", fromTo=" + fromTo
				+ ", toFrom=" + toFrom + ", flightNo=" + flightNo + ", capacity=" + capacity + "]";
	}


		
}
