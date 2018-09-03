package com.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jdbc.Message;

public interface MessageDao {

	public void save(Message message);

	List<Message> findAllMessages();

	List<Message> findMessages(String toUser);

	List<Message> findMessagesThisADay(String toUser, LocalDate day);

	void delete(String toUser);

	void modify(Message oldMessage, String newContent, LocalDateTime newEventTime);

}
