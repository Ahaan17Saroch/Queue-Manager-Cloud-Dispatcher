package com.allen.ms;

import com.sap.cloud.sample.persistence.Person;

public class MS implements Comparable<MS>{
	private int id;
	private int amount;
	private int total;
	private String name;
	private boolean hide; 
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isHide() {
		return hide;
	}
	public void setHide(boolean hide) {
		this.hide = hide;
	}
	
	@Override
	public int compareTo(MS ms) {
		// TODO Auto-generated method stub
		double thisScore = this.amount * 0.80 + (this.total-this.amount)/this.amount * 0.20 + 10;
		double nwScore = ms.amount * 0.80 + (ms.total-ms.amount)/ms.amount * 0.20 + 10;

		if (nwScore > thisScore) {
			return -1;
		}
		if (nwScore < thisScore) {
			return 1;
		}
		return 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
