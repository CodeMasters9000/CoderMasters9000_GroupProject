package com.CodeMasters_9000.model_CodeMasters_9000;

public class MenuItems {
	private String itemID;
	private String name;
	private float cost;
	public void setItemID(String id) {
		this.itemID = id;
	}
	public String getItemID() {
		return itemID;
	}
	public void setName(String nam) {
		this.name = nam;
	}
	public String getName() {
		return name;
	}
	public void setCost(float c) {
		this.cost = c;
	}
	public float getCost() {
		return cost;
	}
}
