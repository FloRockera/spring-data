package com.jdbc;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.formation.service.IFeedbackService;

public class FeedbackToDatabaseService implements IFeedbackService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void say(Feedback newFeedback) {
		this.jdbcTemplate.update("INSERT into feedback (id, user, message, event_time) values (?,?,?,?)",
				newFeedback.getId(), newFeedback.getUser(), newFeedback.getMessage(), newFeedback.getEventTime());
	}

	@Override
	public void amend(Feedback updatedFeedback) {
		this.jdbcTemplate.update("UPDATE feedback set message = ?, event_time = ?, user = ? where id = ?",
				updatedFeedback.getMessage(), updatedFeedback.getEventTime(), updatedFeedback.getUser(),
				updatedFeedback.getId());
	}

	@Override
	public void unSayTo(String user) {
		this.jdbcTemplate.update("DELETE from feedback where user = ?", user);
	}

	@Override
	public List<Feedback> tellMeAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> tellMeWhatWasSaidToHimThisDay(String user, LocalDate day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> listAllFeedbackWith(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
