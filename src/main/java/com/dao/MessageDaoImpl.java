package com.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		TypedQuery<Message> query = em.createQuery("select * from Message", Message.class);
		List<Message> messages = query.getResultList();
		return messages;

	}

	@Override
	public List<Message> findMessages(String toUser) {
		TypedQuery<Message> query = em.createQuery("select m from Message m", Message.class);
		List<Message> messages = query.getResultList();
		return messages;
	}

	@Override
	public List<Message> findMessagesThisADay(String toUser, LocalDate day) {
		TypedQuery<Message> query = em.createQuery("select m from Message m where fromUser=? and event_time = ?",
				Message.class);
		List<Message> messages = query.getResultList();
		return messages;
	}

	@Override
	public void delete(String toUser) {
		Query query = this.em.createQuery("DELETE from message where fromUser=? and toUser = ?", Message.class);
		em.persist(toUser);
	}

	@Override
	public void modify(Message oldMessage, String newContent, LocalDateTime newEventTime) {
		Query query = this.em.createQuery(
				"UPDATE message set content = ?, event_time = ?, toUser = ?, fromUser = ? where idmessage = ?");
		query.setParameter(1, oldMessage.getContent());
		query.setParameter(1, newContent.getContent());
		query.setParameter(1, newEventTime.getEventTime());
		em.persist(query);
	}

}
