package com.byto.dto;

public class UserDto {      //User için veri transferi objesi

	private Long id;   
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String phoneNumber;
	
	private String state;

	
	public UserDto() {
		super();
	}


	public UserDto(Long id, String username, String password, String email, String phoneNumber, String state) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.state = state;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	
}
