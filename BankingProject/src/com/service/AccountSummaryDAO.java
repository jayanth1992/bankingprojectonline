package com.service;

import com.databases.AccountDetails;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountSummaryDAO {
	List<AccountDetails> details;
	@SessionTarget
	Session session;
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<AccountDetails> getDetails(String username) {
		try {
			transaction.begin();
			Query e = session.createQuery("from AccountDetails where username= :userName");
			e.setString("userName", username);
			details = e.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return details;
	}
}