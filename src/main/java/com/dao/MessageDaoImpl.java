package com.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jdbc.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	@PersistenceContext
	public EntityManager em;

	@Override
	public void save(Message message) {
		Query query = this.em.createQuery(
				"INSERT into message (content, event_time, toUser, fromUser, idmessage) values (?,?,?,?,?)");
		query.setParameter(1, message.getContent());
		query.setParameter(1, message.getEventTime());
		query.setParameter(1, message.getToUser());
		query.setParameter(1, message.getFromUser());
		query.setParameter(1, message.getIdmessage());
		em.persist(message);
	}

	@Override
	public List<Message> findAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findMessages(String toUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findMessagesThisADay(String toUser, LocalDate day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String toUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Message oldMessage, String newContent, LocalDateTime newEventTime) {
		// TODO Auto-generated method stub

	}

}
