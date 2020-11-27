package com.CodeMasters_9000.model_CodeMasters_9000;




public class Table{
	/**
	*
	*/
	private int tableID;
	private String reservationID;
	private String serverID;
	private String billID;
	private String seats;
	private String reservationTime;
	private String availableTime;
	private boolean isAvailable;
	


	public void setTableID(int i) {
		this.tableID = i;
	}
	public int getTableID() {
		return tableID;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public String getReservationID() {
		return reservationID;
	}
	public void setServerID(String serverID) {
		this.serverID = serverID;
	}
	public String getServerID() {
		return serverID;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}
	public String getBillID() {
		return billID;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getSeats() {
		return seats;
	}
	public void setReservationTime(String dateTime) {
		this.reservationTime = dateTime;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setIsAvailable(boolean x) {
		this.isAvailable = x;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
	
	
	public void availableTime() {
		String reservationTime = getReservationTime();
		int inHour  = Integer.parseInt(reservationTime.substring(11, 13));
		String outHour = Integer.toString(inHour + 2);
		String availableTime = reservationTime.replace(reservationTime.substring(11, 13), outHour);
		
		setAvailableTime(availableTime);
	}

}
