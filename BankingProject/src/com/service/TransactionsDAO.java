package com.service;

import com.databases.Savings;
import com.databases.Transactions;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionsDAO {
	static final Logger logger = Logger.getLogger(TransactionsDAO.class);
	@SessionTarget
	Session session;
	@TransactionTarget
	Transaction transaction;
	List<Transactions> list;
	List<Savings> list1;

	@SuppressWarnings("unchecked")
	public List<Transactions> getCheckingTransaction(String username) {

		try {
			transaction.begin();
			Query e = session.createQuery("Select date,description,amount from Transactions where username=:userName");
			e.setString("userName", username);
			list = e.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Savings> getSavingsTransactions(String username) {
		try {
			transaction.begin();
			Query e = session.createQuery("from Savings where username=:userName");
			e.setString("userName", username);
			list1 = e.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list1;
	}
}