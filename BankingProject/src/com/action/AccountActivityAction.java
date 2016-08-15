package com.action;

import com.databases.AccountDetails;
import com.databases.Savings;
import com.databases.Transactions;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AccountSummaryDAO;
import com.service.TransactionsDAO;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class AccountActivityAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(AccountActivityAction.class);
	private String checkingAccountName;
	private String savingsAccountName;
	private String checkingAccountNumber;
	private String savingsAccountNumber;
	private int checkingBalance;
	private int savingsBalance;
	private List<Transactions> checkingTransactions;
	private List<Savings> savingsTransactions;
	SessionMap<String, Object> sessionMap;
	List<AccountDetails> accountDetails;
	AccountSummaryDAO accountdao = new AccountSummaryDAO();
	TransactionsDAO transactionsdao = new TransactionsDAO();

	public String getTransactions() {
		if (!(sessionMap.isEmpty())) {
			accountDetails = accountdao.getDetails((String)sessionMap.get("user"));
			Iterator<AccountDetails> i = accountDetails.iterator();

			while (i.hasNext()) {
				AccountDetails accountDetails = (AccountDetails) i.next();
				if (accountDetails.getAccountName().equals("Checking")) {
					setCheckingAccountName(accountDetails.getAccountName());
					setCheckingAccountNumber(accountDetails.getAccountNumber());
					setCheckingBalance(accountDetails.getBalance());
				} else {
					setSavingsAccountName(accountDetails.getAccountName());
					setSavingsAccountNumber(accountDetails.getAccountNumber());
					setSavingsBalance(accountDetails.getBalance());
				}
			}

			logger.info("entering transactionsdao");
			checkingTransactions = transactionsdao.getCheckingTransaction((String)sessionMap.get("user"));
			savingsTransactions = transactionsdao.getSavingsTransactions((String) this.sessionMap.get("user"));
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}

	public String getCheckingAccountName() {
		return this.checkingAccountName;
	}

	public void setCheckingAccountName(String checkingAccountName) {
		this.checkingAccountName = checkingAccountName;
	}

	public String getSavingsAccountName() {
		return this.savingsAccountName;
	}

	public void setSavingsAccountName(String savingsAccountName) {
		this.savingsAccountName = savingsAccountName;
	}

	public String getCheckingAccountNumber() {
		return this.checkingAccountNumber;
	}

	public void setCheckingAccountNumber(String checkingAccountNumber) {
		this.checkingAccountNumber = checkingAccountNumber;
	}

	public String getSavingsAccountNumber() {
		return this.savingsAccountNumber;
	}

	public void setSavingsAccountNumber(String savingsAccountNumber) {
		this.savingsAccountNumber = savingsAccountNumber;
	}

	public int getCheckingBalance() {
		return this.checkingBalance;
	}

	public void setCheckingBalance(int checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public int getSavingsBalance() {
		return this.savingsBalance;
	}

	public void setSavingsBalance(int savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public List<Transactions> getCheckingTransactions() {
		return this.checkingTransactions;
	}

	public void setCheckingTransactions(List<Transactions> checkingTransactions) {
		this.checkingTransactions = checkingTransactions;
	}

	public List<Savings> getSavingsTransactions() {
		return this.savingsTransactions;
	}

	public void setSavingsTransactions(List<Savings> savingsTransactions) {
		this.savingsTransactions = savingsTransactions;
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}
}