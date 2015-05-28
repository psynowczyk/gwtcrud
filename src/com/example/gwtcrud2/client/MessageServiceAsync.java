package com.example.gwtcrud2.client;

import java.util.List;

import com.example.gwtcrud2.client.Message;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessageServiceAsync {
	//void isValidUser(User user, AsyncCallback<Boolean> callback) throws IllegalArgumentException;
	//void setUser(User user, AsyncCallback<Void> callback) throws IllegalArgumentException;
	//void getAllUsers(AsyncCallback<List<User>> callback) throws IllegalArgumentException;
	void getMessages(AsyncCallback<List<Message>> callback);
	void addMessage(Message msg, AsyncCallback<Message> callback);
	void delMessage(Message msg, AsyncCallback<Message> callback);
}
