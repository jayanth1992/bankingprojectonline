package com.databases;

import com.databases.UserDetails;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Address {
	private String zip;
	@ManyToOne
	@JoinColumn(name = "username")
	private UserDetails user;
	@Id
	@Column(name = "DateModified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public UserDetails getUser() {
		return this.user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public Date getDate() {
		return this.date;
	}

	@PreUpdate
	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
}