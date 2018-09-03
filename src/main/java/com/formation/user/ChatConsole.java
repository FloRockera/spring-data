package com.formation.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.service.IMessageService;
import com.jdbc.Message;

public class ChatConsole {

	private String currentUser;

	@Autowired
	private IMessageService service;

	public ChatConsole(String user) {
		this.currentUser = user;
	}

	public void sendHelloTo(String toUser) {
		// écrit "Hello "+toUser dans le message
		Message newMessage = new Message();
		newMessage.setIdmessage(1);
		newMessage.setFromUser(currentUser);
		newMessage.setContent("Hello !");
		newMessage.setToUser(toUser);
		newMessage.setEventTime(LocalDateTime.now());
		service.send(newMessage);
	}

	public void sendGoodbyeTo(String toUser) {
		// écrit "Goodbye "+toUser dans le message
		Message newMessage = new Message();
		newMessage.setIdmessage(2);
		newMessage.setFromUser(currentUser);
		newMessage.setContent("Goodbye !");
		newMessage.setToUser(toUser);
		newMessage.setEventTime(LocalDateTime.now());
		service.send(newMessage);
	}

	public void editMessage(String content, Integer idMessage) {
		// édite le contenu du message identifié avec l'id : idMessage
	}

	public void deleteMessageToUser(String toUser) {
		// Supprime tous les messages vers un utilisateur depuis l'utilisateur
		// courant
	}

	public List<Message> findMessageToUserToday(String toUser) {
		return null;
		// Récupère tous les messages envoyés par l'utilisateur courant vers un
		// utilisateur donné, aujourd'hui

	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public void setService(IMessageService service) {
		this.service = service;
	}

}