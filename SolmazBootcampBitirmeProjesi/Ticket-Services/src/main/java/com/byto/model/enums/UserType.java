package com.byto.model.enums;

public enum UserType {

	INDIVIDUAL("bireysel"),
	CORPARETE("kurumsal");
	
	private String label;

	UserType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
}

