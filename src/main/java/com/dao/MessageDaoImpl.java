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
		TypedQuery<Message> query = em
				.createQuery("select m from Message m where fromUser=:user and event_time = :time", Message.class);
		query.setParameter("user", toUser);
		query.setParameter("time", day);
		List<Message> messages = query.getResultList();
		return messages;
	}

	@Override
	public void delete(String fromUser, String toUser) {
		Query query = this.em.createQuery("select * from message where fromUser=? and toUser = ?", Message.class);
		// faire une boucle
		em.remove(parametreattendu);
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
