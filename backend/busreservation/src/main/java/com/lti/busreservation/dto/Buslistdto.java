package com.lti.busreservation.dto;

import com.lti.busreservation.models.Admin;

public class Buslistdto {
	
	
	int id;
	String busType;
	int noSeats;
	String busNo;
	boolean sleeper;
	boolean ac;
	int admin;
	
	
	public  String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getNoSeats() {
		return noSeats;
	}
	public void setNoSeats(int noSeats) {
		this.noSeats = noSeats;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public boolean getSleeper() {
		return sleeper;
	}
	public void setSleeper(boolean sleeper) {
		this.sleeper = sleeper;
	}
	public boolean getAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}

