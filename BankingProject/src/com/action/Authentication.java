package com.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class Authentication extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	SessionMap<String, Object> sessionMap;

	public String authenticate() {
		return ((!(sessionMap.isEmpty()))) ? SUCCESS : LOGIN;
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = (SessionMap<String, Object>) session;
	}
}