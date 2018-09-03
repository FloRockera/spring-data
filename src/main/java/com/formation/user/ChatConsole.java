package com.formation.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.service.IMessageService;
import com.formation.service.MessageToDatabaseService;
import com.jdbc.Message;

public class ChatConsole {

	private String currentUser;

	@Autowired
	private MessageToDatabaseService service;

	public ChatConsole(String user) {
		this.currentUser = user;
	}

	@Autowired
	public void setMessage(IMessageService service) {
		this.service = (MessageToDatabaseService) service;
	}

	public void sendHelloTo(String toUser) {
		// écrit "Hello "+toUser dans le message
		Message newMessage = new Message();
		newMessage.setIdmessage(1);
		newMessage.setContent("Hello !");
		newMessage.setToUser("Nom");
	}

	public void sendGoodbyeTo(String toUser) {
		// écrit "Goodbye "+toUser dans le message
		Message newMessage = new Message();
		newMessage.setIdmessage(1);
		newMessage.setContent("Goodbye !");
		newMessage.setToUser("Nom");
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

}