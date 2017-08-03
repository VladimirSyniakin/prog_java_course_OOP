package com.gmail.vsyniakin;

public class Human {
	private String firstName;
	private String secondName;
	
	public Human(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public Human() {
		super();
	}

	@Override
	public String toString() {
		return "Human [firstName=" + firstName + ", secondName=" + secondName + "]";
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
}	