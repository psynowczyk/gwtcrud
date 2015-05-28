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
		msg.setId(this.messages.size());
		this.messages.add(msg);
		return msg;
	}

	public Message delMessage(Message msg) {
		int index = msg.getId();
		for (int x = index + 1; x < this.messages.size(); x++) {
			this.messages.get(x).setId(x-1);
		}
		this.messages.remove(index);
		return msg;
	}

}
