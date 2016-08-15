package com.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class SignOffAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	SessionMap<String, Object> sessionMap;

	public String execute() {
		if (!(sessionMap.isEmpty())) {
			sessionMap.remove("loggedIn");
			sessionMap.remove("user");
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}
}