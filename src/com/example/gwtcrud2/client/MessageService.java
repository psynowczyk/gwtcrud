package com.example.gwtcrud2.client;

import java.util.List;
import com.example.gwtcrud2.client.Message;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("message")
public interface MessageService extends RemoteService {
	//boolean isValidUser(User user);
	//Message setUser(User user) throws IllegalArgumentException;
	//List<User> getAllUsers() throws IllegalArgumentException;
	List<Message> getMessages();
	Message addMessage(Message msg);
}
