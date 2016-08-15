package com.service;

import com.databases.Address;
import com.databases.UserDetails;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateDAO {
	static final Logger logger = Logger.getLogger(UpdateDAO.class);
	List<Address> list;
	@SessionTarget
	Session session;
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<Address> getDetails(String username) {
		try {
			transaction.begin();
			Query e = session.createQuery("from Address where user.userName = :username order by date desc");
			e.setMaxResults(1);
			e.setString("username", username);
			list = e.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void updateInformation(String username, String firstName, String lastName, String email, String phoneNumber,
			String addressLine1, String addressLine2, String city, String state, String zip) {
		Address address = new Address();
		UserDetails user = new UserDetails();
		Query query = session.createQuery("from UserDetails where userName= :username");
		query.setString("username", username);
		List users = query.list();
		user = (UserDetails) users.get(0);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		address.setUser(user);
		address.setDate(new Date());
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		session.save(user);
		session.save(address);
	}
}