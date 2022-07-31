package com.lti.busreservation.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="unauthorizeduser")
public class Unauthorizeduser {
	@Id
//	@SequenceGenerator(name="unauthorized_id",initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="email")
	String email;
	@Column(name="phoneno")
	String phoneno;
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="bookid")
	Booking booking;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	

}
