package com.formation.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.repository.MessageRepository;
import com.jdbc.Message;
import com.jdbc.MessageDto;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService, MessageRepository {

	@Override
	public void send(MessageDto message) {
	}

	@Override
	public void edit(MessageDto editedMsg) {

	}

	@Override
	public void delete(String fromUser, String toUser) {
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	}

	@Override
	public List<MessageDto> findAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageDto> findMessageSendToAUserADay(String toUser, LocalDate day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageDto> findAllMessageFromUser(String fromUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteInBatch(Iterable<Message> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Message> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Message> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findAllById(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public Message getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Message> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Message> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Message> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Message arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Message> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Message> findById(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Message> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Message> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Message> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Message> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Message> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByToUser(String toUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByFromUser(String fromUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByToUserAndEventTimeBetween(String toUser, LocalDateTime startTime,
			LocalDateTime endTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
