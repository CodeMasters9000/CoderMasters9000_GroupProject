package com.CodeMasters_9000.model_CodeMasters_9000;

import java.util.Date;

public class Bill{
	/**
	*
	*/
	private String billID;
	private String reservationID;
	private String serverID;
	private String itemsOrdered;
	private String itemsComped;
	private float subtotal;
	private float tip;
	private float total;
	private boolean isPaid;
	private Date seatTime;
	private Date leaveTime;


	public void setBillID(String id) {
		this.billID = id;
	}
	public String getBillID() {
		return billID;
	}
	public void setReservationID(String id) {
		this.reservationID = id;
	}
	public String getReservationID() {
		return reservationID;
	}
	public void setServerID(String id) {
		this.serverID = id;
	}
	public String getServerID() {
		return serverID;
	}
	public void setItemsOrdered(String items) {
		this.itemsOrdered = items;
	}
	public String getItemsOrdered() {
		return itemsOrdered;
	}
	public void setItemsComped(String items) {
		this.itemsComped = items;
	}
	public String getItemsComped() {
		return itemsComped;
	}
	public void setSubtotal(float st) {
		this.subtotal = st;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setTip(float tip) {
		this.tip= tip;
	}
	public float getTip() {
		return tip;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getTotal() {
		return total;
	}
	public void setIsPaid(boolean x) {
		this.isPaid = x;
	}
	public boolean getIsPaid() {
		return isPaid;
	}
	public void setSeatTime(Date seating) {
		this.seatTime = seating;
	}
	public Date getSeatTime() {
		return seatTime;
	}
	public void setLeaveTime(Date leave) {
		this.leaveTime = leave;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
//returns time in hours
	public float getTotalTime() {
		Long total = (leaveTime.getTime() - seatTime.getTime());
		float totalTime = total/1000/60/60;
		return totalTime;
	}

}
