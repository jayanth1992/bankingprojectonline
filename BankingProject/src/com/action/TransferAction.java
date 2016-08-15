package com.action;

import com.databases.AccountDetails;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TransfersDAO;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class TransferAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	List<AccountDetails> details;
	static final Logger logger = Logger.getLogger(TransferAction.class);
	private String transferFrom;
	private String transferTo;
	private int amount;
	private String Checking = "02";
	private String Saving = "03";
	private int balance;
	TransfersDAO dao = new TransfersDAO();

	public String transfer() {
		if (!(sessionMap.isEmpty())) {
			details = dao.getBalances((String)sessionMap.get("user"));
			Iterator<AccountDetails> i = details.iterator();

			while (i.hasNext()) {
				AccountDetails accountDetails = (AccountDetails) i.next();
				if (transferFrom.equals(Checking) && accountDetails.getAccountName().equals("Checking")) {
					setBalance(accountDetails.getBalance());
				}

				if (transferFrom.equals(Saving) && accountDetails.getAccountName().equals("Savings")) {
					setBalance(accountDetails.getBalance());
				}
			}

			if (transferFrom.equals(Checking) && transferTo.equals(Saving) && amount <= balance) {
				dao.update("Checking", "Savings", amount);
				return SUCCESS;
			} else if (transferFrom.equals(Saving) && transferTo.equals(Checking) && amount <= balance) {
				dao.update("Savings", "Checking", amount);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			return LOGIN;
		}
	}

	public String getTransferFrom() {
		return this.transferFrom;
	}

	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}

	public String getTransferTo() {
		return this.transferTo;
	}

	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}
}