package com.action;

import com.databases.AccountDetails;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AccountSummaryDAO;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class AccountSummaryAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String checkingAccountNumber;
	private String savingsAccountNumber;
	private int checkingBalance;
	private int savingsBalance;
	static final Logger logger = Logger.getLogger(AccountSummaryAction.class);
	private List<AccountDetails> details;
	SessionMap<String, Object> sessionMap;
	AccountSummaryDAO dao = new AccountSummaryDAO();

	public String fetchDetails() {
		if (!(sessionMap.isEmpty())) {
			details = dao.getDetails((String) sessionMap.get("user"));
			Iterator<AccountDetails> i = details.iterator();

			while (i.hasNext()) {
				AccountDetails accountDetails = (AccountDetails) i.next();
				if (accountDetails.getAccountName().equals("Checking")) {
					setCheckingAccountNumber(accountDetails.getAccountNumber());
					setCheckingBalance(accountDetails.getBalance());
				} else {
					setSavingsAccountNumber(accountDetails.getAccountNumber());
					setSavingsBalance(accountDetails.getBalance());
				}
			}

			return SUCCESS;
		} else {
			return LOGIN;
		}
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

	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}
}