package com.example.gwtcrud2.client;


import java.util.List;

import com.example.gwtcrud2.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;


public class Gwtcrud2 implements EntryPoint {

	private final MessageServiceAsync MessageService = GWT.create(MessageService.class);	
	
	class DelHandler implements ClickHandler {
		Message msg;
		public DelHandler(Message msg) {
			this.msg = msg;
		}

		public void onClick(ClickEvent event) {
			MessageService.delMessage(msg, new AsyncCallback<Message>() {
				@Override
				public void onFailure(Throwable caught) {
					//RootPanel.get("list").add(new Label("Fail"));
				}
				@Override
				public void onSuccess(Message result) {
					MessageService.getMessages(new GetMessagesCallback());
				}	   
			});
		}
	}
	
	class GetMessagesCallback implements AsyncCallback<List<Message>> {
		@Override
		public void onFailure(Throwable caught) {
			RootPanel.get("list").clear();
			RootPanel.get("list").add(new Label("Unable to obtain server response: "+ caught.getMessage()));
		}
		@Override
		public void onSuccess(List<Message> result) {
			RootPanel.get("list").clear();
			for (Message msg : result) {
				FlowPanel msglistelem = new FlowPanel();
				msglistelem.setStylePrimaryName("msglistelem");
				Label msgtext = new Label("#"+ (msg.getId() + 1) +" "+ msg.getUsername() +": "+ msg.getMessage());
				msgtext.setStylePrimaryName("msgtext");
				Label msgdelete = new Label("-");
				msgdelete.setStylePrimaryName("msgdelete");
				msgdelete.addClickHandler(new DelHandler(msg));
				msglistelem.add(msgtext);
				msglistelem.add(msgdelete);
				RootPanel.get("list").add(msglistelem);
			}
		}	   
	}

	public void onModuleLoad() {
		MessageService.getMessages(new GetMessagesCallback());

		final TextBox FormNameField = new TextBox();
		final TextBox FormMsgField = new TextBox();
		final Button FormSubmitAddMsg = new Button("send");
		final Label errorLabel = new Label();
		
		RootPanel.get("username_box").add(FormNameField);
		RootPanel.get("message_box").add(FormMsgField);
		RootPanel.get("submit_box").add(FormSubmitAddMsg);
		RootPanel.get("form").add(errorLabel);
		
		class FormHandler implements ClickHandler {
					
			public void onClick(ClickEvent event) {
				sendMessageToServer();
			}
			
			private void sendMessageToServer() {
				errorLabel.setText("");
				Message message = new Message();
				message.setUsername(FormNameField.getText());
				message.setMessage(FormMsgField.getText());
				if (!FieldVerifier.isValidName(message.getUsername()) || !FieldVerifier.isValidMsg(message.getMessage())) {
					errorLabel.setText("Please enter correct username and message.");
					return;
				}
				else {
					MessageService.addMessage(message, new AsyncCallback<Message>() {
						@Override
						public void onFailure(Throwable caught) {
							RootPanel.get("list").add(new Label("Unable to obtain server response: "+ caught.getMessage()));
						}
						@Override
						public void onSuccess(Message result) {
							FlowPanel msglistelem = new FlowPanel();
							msglistelem.setStylePrimaryName("msglistelem");
							Label msgtext = new Label("#"+ (result.getId() + 1) +" "+ result.getUsername() +": "+ result.getMessage());
							msgtext.setStylePrimaryName("msgtext");
							Label msgdelete = new Label("-");
							msgdelete.setStylePrimaryName("msgdelete");
							msgdelete.addClickHandler(new DelHandler(result));
							msglistelem.add(msgtext);
							msglistelem.add(msgdelete);
							RootPanel.get("list").add(msglistelem);
						}	   
					});
				}
			}
		}
		
		FormHandler handler = new FormHandler();
		FormSubmitAddMsg.addClickHandler(handler);
		
	}
}
