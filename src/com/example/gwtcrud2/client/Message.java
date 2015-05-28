package com.example.gwtcrud2.client;

import java.io.Serializable;


public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username = "";
	private String message = "";
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
