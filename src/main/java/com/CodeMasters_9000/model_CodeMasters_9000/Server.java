package com.CodeMasters_9000.model_CodeMasters_9000;

public class Server {
		private String serverID;
		private String serverName;
		private String assignedTables;
		private String phoneNumber;
		private String password;
	public void setServerID(String id) {
		this.serverID = id;
	}
	public String getServerID() {
		return serverID;
	}
	public void setServerName(String name) {
		this.serverName = name;
	}
	public String getServerName() {
		return serverName;
	}
	public void setAssignedTables(String tables) {
		this.assignedTables = tables;
	}
	public String getAssignedTables() {
		return assignedTables;
	}
	public void setPhoneNumber(String number) {
		this.phoneNumber = number;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPassword(String pw) {
	this.password = pw;
	}
	public String getPassword() {
		return password;
	}
}