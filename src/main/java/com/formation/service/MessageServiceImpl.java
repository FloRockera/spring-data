package com.formation.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MessageDaoImpl;
import com.jdbc.MessageDto;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

	@Override
	public void send(MessageDto message) {
		MessageDaoImpl dao = new MessageDaoImpl();
		dao.save(message);
	}

	@Override
	public void edit(MessageDto editedMsg) {
		this.jdbcTemplate.update(
				"UPDATE message set content = ?, event_time = ?, toUser = ?, fromUser = ? where idmessage = ?",
				editedMsg.getContent(), editedMsg.getEventTime(), editedMsg.getToUser(), editedMsg.getFromUser(),
				editedMsg.getIdmessage());
	}

	@Override
	public void delete(String fromUser, String toUser) {
		this.jdbcTemplate.update("DELETE from message where fromUser=? and toUser = ?", fromUser, toUser);

	}

	@Override
	public List<MessageDto> findAllMessages() {
		TypedQuery<MessageDto> messages = em.createQuery("select p from message p", MessageDto.class);
		List<MessageDto> messages = query.getResultList();
		return messages;

	}

	@Override
	public List<MessageDto> findMessageSendToAUserADay(String toUser, LocalDate day) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String SQL = "SELECT * from message where toUser = ? and DATE(event_time) = ?";
		List<MessageDto> messages = jdbcTemplate.query(SQL, new Object[] { toUser, formatter.format(day) },
				new MessageMapper<>());
		messages.forEach(i -> {
			System.out.println("object : " + i);
		});
		return messages;
	}

	@Override
	public List<MessageDto> findAllMessageFromUser(String fromUser) {
		String SQL = "SELECT * from message where fromUser = ?";
		List<MessageDto> messages = jdbcTemplate.query(SQL, new Object[] { fromUser }, new MessageMapper<>());
		messages.forEach(i -> {
			System.out.println("object : " + i);
		});
		return messages;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
