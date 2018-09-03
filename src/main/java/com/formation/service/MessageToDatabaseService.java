package com.formation.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.Message;

public class MessageToDatabaseService implements IMessageService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MessageToDatabaseService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(Message message) {
		this.jdbcTemplate.update(
				"INSERT into message (content, event_time, toUser, fromUser, idmessage) values (?,?,?,?,?)",
				message.getContent(), message.getEventTime(), message.getToUser(), message.getFromUser(),
				message.getIdmessage());
	}

	@Override
	public void edit(Message editedMsg) {
		this.jdbcTemplate.update(
				"UPDATE message set content = ?, event_time = ?, toUser = ?, fromUser = ?, where id = ?",
				editedMsg.getContent(), editedMsg.getEventTime(), editedMsg.getToUser(), editedMsg.getFromUser(),
				editedMsg.getIdmessage());
	}

	@Override
	public void delete(String fromUser, String toUser) {
		this.jdbcTemplate.update("DELETE from message where fromUser=? and toUser = ?", fromUser, toUser);

	}

	@Override
	public List<Message> findAllMessages() {
		return null;

	}

	@Override
	public List<Message> findMessageSendToAUserADay(String toUser, LocalDate day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findAllMessageFromUser(String fromUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
