package com.formation.service;

import org.springframework.stereotype.Component;

@Component
public class FeedbackToConsole implements IFeedback {

	public void say(String something) {

		System.out.println(something);
	}

	@Override
	public void unsay(String format) {
		// TODO Auto-generated method stub

	}

	@Override
	public void amend(String format) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tellMeAll(String format) {
		// TODO Auto-generated method stub

	}

}
