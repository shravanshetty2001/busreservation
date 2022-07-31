package com.lti.busreservation.models;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name="email")
	String email;
	@Column(name="password")
	String password;
	@Column(name="travelname")
	String travelname;
	@Column(name="contactno")
	String contactno;
	@OneToMany(targetEntity=Buslist.class,cascade=CascadeType.ALL)
	@JoinColumn(name="bususerid",referencedColumnName = "id")
	private List<Buslist> buslist;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTravelname() {
		return travelname;
	}
	public void setTravelname(String travelname) {
		this.travelname = travelname;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public List<Buslist> getBuslist() {
		return buslist;
	}
	public void setBuslist(List<Buslist> buslist) {
		this.buslist = buslist;
	}

}
