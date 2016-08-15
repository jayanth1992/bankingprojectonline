package com.action;

import com.databases.Address;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UpdateDAO;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class UpdateAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	SessionMap<String, Object> sessionMap;
	List<Address> list;
	static final Logger logger = Logger.getLogger(UpdateAction.class);
	UpdateDAO dao = new UpdateDAO();
	Address address = new Address();

	public String getUserInfo() {
		if (!(sessionMap.isEmpty())) {
			list = dao.getDetails((String)sessionMap.get("user"));
			address = (Address) list.get(0);
			setFirstName(address.getUser().getFirstName());
			setLastName(address.getUser().getLastName());
			setEmail(address.getUser().getEmail());
			setPhoneNumber(address.getUser().getPhoneNumber());
			setAddressLine1(address.getAddressLine1());
			setAddressLine2(address.getAddressLine2());
			setCity(address.getCity());
			setState(address.getState());
			setZip(address.getZip());
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}

	public String updateInformation() {
		this.dao.updateInformation((String) this.sessionMap.get("user"), this.firstName, this.lastName, this.email,
				this.phoneNumber, this.addressLine1, this.addressLine2, this.city, this.state, this.zip);
		return "success";
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}
}