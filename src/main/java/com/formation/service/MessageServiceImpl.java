package com.formation.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MessageDao;
import com.formation.repository.MessageRepository;
import com.jdbc.Message;
import com.jdbc.MessageDto;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

	@Autowired
	MessageDao dao;

	@Autowired
	MessageRepository repository;

	@Override
	public void send(MessageDto message) {
		Message newMessage = new Message(message.getFromUser(), message.getToUser(), message.getContent());
		dao.save(newMessage);

	}

	@Override
	public void edit(MessageDto editedMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String fromUser, String toUser) {

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
		List<Message> messages = repository.findByFromUser(fromUser);
		List<MessageDto> messagesDto = new ArrayList<MessageDto>();
		for (Message message : messages) {
			messagesDto.add(fromMessageToMessageDto(message));
		}
		return messagesDto;
	}

	private MessageDto fromMessageToMessageDto(Message message) {
		MessageDto newMessageDto = new MessageDto();
		newMessageDto.setFromUser(message.getFromUser());
		newMessageDto.setToUser(message.getToUser());
		newMessageDto.setContent(message.getContent());
		newMessageDto.setEventTime(message.getEventTime());
		return newMessageDto;
	}

}
