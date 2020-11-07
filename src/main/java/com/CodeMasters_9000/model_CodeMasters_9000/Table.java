package com.CodeMasters_9000.model_CodeMasters_9000;

import java.util.Date;


public class Table{
	/**
	*
	*/
	private int tableID;
	private int reservationID;
	private int serverID;
	private int billID;
	private int seats;
	private Date reservationTime;
	private Date availableTime;
	private boolean isAvailable;


	public void setTableID(int i) {
		this.tableID = i;
	}
	public int getTableID() {
		return tableID;
	}
	public void setReservationID(int id) {
		this.reservationID = id;
	}
	public int getReservationID() {
		return reservationID;
	}
	public void setServerID(int id) {
		this.serverID = id;
	}
	public int getServerID() {
		return serverID;
	}
	public void setBillID(int id) {
		this.billID = id;
	}
	public int getBillID() {
		return billID;
	}
	public void setSeats(int seat) {
		this.seats = seat;
	}
	public int getSeats() {
		return seats;
	}
	public void setReservationTime(Date reservation) {
		this.reservationTime = reservation;
	}
	public Date getReservationTime() {
		return reservationTime;
	}
	public void setAvailableTime(Date available) {
		this.availableTime = available;
	}
	public Date getAvailableTime() {
		return availableTime;
	}
	public void setIsAvailable(boolean x) {
		this.isAvailable = x;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}

}
