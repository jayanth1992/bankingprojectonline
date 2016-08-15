package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.LoginDAO;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {
	static final Logger logger = Logger.getLogger(LoginAction.class);
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String selectedAccount;
	private boolean saveUserName;
	private HttpServletResponse response;
	@SuppressWarnings("unused")
	private HttpServletRequest request;
	
	private SessionMap<String, Object> sessionMap;
	LoginDAO dao = new LoginDAO();

	public void validate() {
		
		if (userName.isEmpty()) {
			this.addFieldError("userName", "Username cannot be empty");
		}

		if (password.isEmpty()) {
			this.addFieldError("password", "Password Cannot be empty");
		}

	}

	public String authenticate() {
		if (dao.check(userName, password)) {
			sessionMap.put("user", userName);
			sessionMap.put("loggedIn",true);
			if(saveUserName){ createCookie(); } 
			return getSelectedAccount();
		} else {
			return ERROR;
		}
	}
	
	public void createCookie(){
		Cookie cookie = new Cookie("username", getUserName());
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
	}
	
	public boolean isSaveUserName() {
		return saveUserName;
	}

	public void setSaveUserName(boolean saveUserName) {
		this.saveUserName = saveUserName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSelectedAccount() {
		return this.selectedAccount;
	}

	public void setSelectedAccount(String selectedAccount) {
		this.selectedAccount = selectedAccount;
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
}