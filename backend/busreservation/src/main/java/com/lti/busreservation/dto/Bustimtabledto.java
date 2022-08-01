package com.lti.busreservation.dto;



import java.sql.Timestamp;

import com.lti.busreservation.models.Buslist;
import com.lti.busreservation.models.Place;

public class Bustimtabledto {
	
	Timestamp sDatetime;
	Timestamp dDatetime;
	Place sourcePlace;
	Place desnPlace;
	Buslist Blid;
	
	public Timestamp getsDatetime() {
		return sDatetime;
	}
	public void setsDatetime(Timestamp sDatetime) {
		this.sDatetime = sDatetime;
	}
	public Timestamp getdDatetime() {
		return dDatetime;
	}
	public void setdDatetime(Timestamp dDatetime) {
		this.dDatetime = dDatetime;
	}
	public Place getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(Place sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public Place getDesnPlace() {
		return desnPlace;
	}
	public void setDesnPlace(Place desnPlace) {
		this.desnPlace = desnPlace;
	}
	public Buslist getBlid() {
		return Blid;
	}
	public void setBlid(Buslist blid) {
		Blid = blid;
	}
	
	
	
}
