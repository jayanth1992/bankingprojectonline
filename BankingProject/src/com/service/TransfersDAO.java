package com.service;

import com.databases.AccountDetails;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransfersDAO {
	static final Logger logger = Logger.getLogger(TransfersDAO.class);
	@SessionTarget
	Session session;
	@TransactionTarget
	Transaction transaction;
	List<AccountDetails> list;

	@SuppressWarnings("unchecked")
	public List<AccountDetails> getBalances(String username) {
		try {
			transaction.begin();
			Query e = session.createQuery("from AccountDetails where username = :userName");
			e.setString("userName", username);
			list = e.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@SuppressWarnings("rawtypes")
	public void update(String fromAcc, String toAcc, int amount) {
		AccountDetails fromAccount = new AccountDetails();
		AccountDetails toAccount = new AccountDetails();
		Iterator i = list.iterator();

		while (i.hasNext()) {
			AccountDetails e = (AccountDetails) i.next();
			if (e.getAccountName().equals(fromAcc)) {
				fromAccount = e;
			}

			if (e.getAccountName().equals(toAcc)) {
				toAccount = e;
			}
		}
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		try {
			
			transaction.begin();
			session.save(fromAccount);
			session.save(toAccount);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}