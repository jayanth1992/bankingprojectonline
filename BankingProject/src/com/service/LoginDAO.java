package com.service;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginDAO {
	static final Logger logger = Logger.getLogger(LoginDAO.class);
	@SessionTarget
	Session session;
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("rawtypes")
	public boolean check(String username, String password) {
		try {
			transaction.begin();
			Query e = session.createQuery("from UserDetails where userName = :username and password = :Password");
			e.setString("username", username);
			e.setString("Password", password);
			List user = e.list();
			transaction.commit();
			return !user.isEmpty();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}
}