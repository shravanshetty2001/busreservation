package com.lti.busreservation.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name="buslist")
public class Buslist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="busType")
	String busType;
	@Column(name="noSeats")
	int noSeats;
	@Column(name="busNo")
	String busNo;
	@Column(name="sleeper")
	boolean sleeper;
	@Column(name="ac")
	boolean ac;
	@ManyToOne
	@JoinColumn(name="adminfk")
	Admin admin;
	@OneToMany(targetEntity=Bustimetable.class,cascade=CascadeType.ALL)
	@JoinColumn(name="busid",referencedColumnName = "id")
	private List<Bustimetable> bustimetable;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBusType() {
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
	public boolean isSleeper() {
		return sleeper;
	}
	public void setSleeper(boolean sleeper) {
		this.sleeper = sleeper;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List<Bustimetable> getBustimetable() {
		return bustimetable;
	}
	public void setBustimetable(List<Bustimetable> bustimetable) {
		this.bustimetable = bustimetable;
	}
	
	
	

}
