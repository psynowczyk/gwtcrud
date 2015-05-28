package com.example.gwtcrud2.client;

import java.io.Serializable;
import java.util.Date;

import com.google.gwt.i18n.shared.DateTimeFormat;


public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username = "";
	private String message = "";
	private String date = DateTimeFormat.getFormat("EEEE, MMMM dd, yyyy").format(new Date());
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
