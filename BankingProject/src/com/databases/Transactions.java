package com.databases;

import com.databases.UserDetails;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transactions {
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "TransactionDate")
	private Date date;
	@ManyToOne
	@JoinColumn(name = "username")
	private UserDetails user;
	private String description;
	private int amount;

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserDetails getUser() {
		return this.user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}