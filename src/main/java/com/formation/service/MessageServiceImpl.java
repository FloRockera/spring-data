package com.formation.service;

import java.time.LocalDate;
import java.util.List;

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

	}

	@Override
	public void delete(String fromUser, String toUser) {
	}

	@Override
	public List<MessageDto> findAllMessages() {
	}

	@Override
	public List<MessageDto> findMessageSendToAUserADay(String toUser, LocalDate day) {
	}

	@Override
	public List<MessageDto> findAllMessageFromUser(String fromUser) {
	}

	public JdbcTemplate getJdbcTemplate() {
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	}

}
