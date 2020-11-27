package com.CodeMasters_9000.model_CodeMasters_9000;

public class Reservation {
	private String reservationID;
	private String noOfPeople;
	private String email;
	private String name;
	public void setReservationID(String id) {
		this.reservationID = id;
	}
	public String getReservationID() {
		return reservationID;
	}
	public void setNoOfPeople(String n) {
		this.noOfPeople = n;
	}
	public String getNoOfPeople() {
		return noOfPeople;
	}
	public void setEmail(String e) {
		this.email = e;
	}
	public String getEmail() {
		return email;
	}
	public void setName(String n) {
		this.name = n;
	}
	public String getName() {
		return name;
	}
}
