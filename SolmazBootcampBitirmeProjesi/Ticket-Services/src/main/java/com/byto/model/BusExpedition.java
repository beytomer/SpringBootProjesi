package com.byto.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
 


@Entity
@Table(name="BusExpedition")
public class BusExpedition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String boardingTime;//saati
	
	private LocalDate date;
	
	private String fromTo;
	
	private String toFrom;
	
	private Long expeditionNumber;//sefer no
	
	private final int capacity = 45;
	

	private Double pay;

	public BusExpedition() {
		super();
	}
	
	public BusExpedition(Long id, String boardingTime, LocalDate date, String fromTo, String toFrom,
			Long expeditionNumber ) {
		super();
		this.id = id;
		this.boardingTime = boardingTime;
		this.date = date;
		this.fromTo = fromTo;
		this.toFrom = toFrom;
		this.expeditionNumber = expeditionNumber;
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


	@Override
	public String toString() {
		return "BusExpedition [id=" + id + ", boardingTime=" + boardingTime + ", date=" + date + ", fromTo=" + fromTo
				+ ", toFrom=" + toFrom + ", expeditionNumber=" + expeditionNumber + ", capacity=" + capacity + ", pay="
				+ pay + "]";
	}


	
	
}
