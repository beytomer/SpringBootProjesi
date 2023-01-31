package com.byto.dto;

import java.time.LocalDate;
import java.util.Date;

public class BusExpeditionDto {    // Otobüs seferi veri transferi objesi

	private Long id;
	
	private String boardingTime;
	
	private LocalDate date ;
	
	private String fromTo;
	
	private String toFrom;
	
	private Long expeditionNumber;//sefer no

	private Double pay;
	
	public BusExpeditionDto() {
		super();
	}
	
	public BusExpeditionDto(Long id, String boardingTime, LocalDate date, String fromTo, String toFrom,
			Long expeditionNumber, Double pay) {
		super();
		this.id = id;
		this.boardingTime = boardingTime;
		this.date = date;
		this.fromTo = fromTo;
		this.toFrom = toFrom;
		this.expeditionNumber = expeditionNumber;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getFromTo() {
		return fromTo;
	}

	public void setFromTo(String fromTo) {
		this.fromTo = fromTo;
	}

	public String getToFrom() {
		return toFrom;
	}

	public void setToFrom(String toFrom) {
		this.toFrom = toFrom;
	}

	public Long getExpeditionNumber() {
		return expeditionNumber;
	}

	public void setExpeditionNumber(Long expeditionNumber) {
		this.expeditionNumber = expeditionNumber;
	}


	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	
	
	
}
