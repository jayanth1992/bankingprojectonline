package com.databases;

import com.databases.UserDetails;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Savings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date datemodified;
	private int depositAmount;
	private String description;
	@ManyToOne
	@JoinColumn(name = "username")
	private UserDetails user;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepositAmount() {
		return this.depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public UserDetails getUser() {
		return this.user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public Date getDatemodified() {
		return this.datemodified;
	}

	public void setDatemodified(Date datemodified) {
		this.datemodified = datemodified;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}