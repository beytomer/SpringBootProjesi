package com.byto.dto;

import java.util.Date;

public class FlightExpeditionDto {      //Uçak seferi için veri transferi objesi

	private Long id;
	
	private String boardingTime;
	
	private Date date;
	
	private String fromTo;
	
	private String toFrom;
	
	private String flightNo;
	
	private Double pay;

	public FlightExpeditionDto(Long id, String boardingTime, Date date, String fromTO, String toFrom, String flightNo) {
		super();
		this.id = id;
		this.boardingTime = boardingTime;
		this.date = date;
		this.fromTo = fromTO;
		this.toFrom = toFrom;
		this.flightNo = flightNo;
	}

	public FlightExpeditionDto() {
		super();
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
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

	
}
