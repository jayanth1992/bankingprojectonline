package com.databases;

import com.databases.UserDetails;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountDetails {
	@Id
	private String accountNumber;
	private int balance;
	private String accountName;
	@ManyToOne
	@JoinColumn(name = "username")
	private UserDetails user;

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public UserDetails getUser() {
		return this.user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
}