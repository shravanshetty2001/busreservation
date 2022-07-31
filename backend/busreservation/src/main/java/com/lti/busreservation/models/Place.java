package com.lti.busreservation.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="place")
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="placename")
	String placeName;
	@OneToMany(targetEntity =Booking.class,cascade = CascadeType.ALL)
	List<Bustimetable> bustimetable;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public List<Bustimetable> getBustimetable() {
		return bustimetable;
	}
	public void setBustimetable(List<Bustimetable> bustimetable) {
		this.bustimetable = bustimetable;
	}
}
