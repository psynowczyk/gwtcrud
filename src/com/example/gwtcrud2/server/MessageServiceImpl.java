package com.example.gwtcrud2.server;

import java.util.ArrayList;
import java.util.List;

import com.example.gwtcrud2.client.Message;
import com.example.gwtcrud2.client.MessageService;
import com.example.gwtcrud2.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class MessageServiceImpl extends RemoteServiceServlet implements MessageService {
	
	private List<Message> messages = new ArrayList<Message>();
	
	public List getMessages() {
		return messages;
	}
	
	public Message addMessage(Message msg) {
		this.messages.add(msg);
		return msg;
	}
	// validate user
	/*
	public boolean isValidUser(User user) throws IllegalArgumentException {
		if (!FieldVerifier.isValidName(user.getName()) || !FieldVerifier.isValidDob(user.getDob())) {
			throw new IllegalArgumentException("Name must contain Firstname and Lastname.");
		}
		else return true;
	}
	
	// set user
	public void setUser(User user) throws IllegalArgumentException {
		this.users.add(user);
	}
	
	// get all users
	public List<User> getAllUsers() throws IllegalArgumentException {
		return users;
	}
	*/

}
