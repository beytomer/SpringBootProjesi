package com.byto.dto;

public class PlaneTicketDto {          //uçak bileti için veri transferi objesi

	private Long id; 
	
	private Long expeditionId;
	
	private Long userId;
	
	private String gender;
	
	private Long personCount;

	
	public PlaneTicketDto() {
		super();
	}

	
	public PlaneTicketDto(Long id, Long expeditionId, Long userId, String gender, Long personCount) {
		super();
		this.id = id;
		this.expeditionId = expeditionId;
		this.userId = userId;
		this.gender = gender;
		this.personCount = personCount;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getExpeditionId() {
		return expeditionId;
	}


	public void setExpeditionId(Long expeditionId) {
		this.expeditionId = expeditionId;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPersonCount() {
		return personCount;
	}

	public void setPersonCount(Long personCount) {
		this.personCount = personCount;
	}



	
}

