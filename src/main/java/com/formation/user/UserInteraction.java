package com.formation.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.service.IFeedback;
import com.jdbc.Feedback;
import com.jdbc.FeedbackToDatabaseService;

//Classe pour r�aliser les int�ractions avec les utilisateurs
@Component
public class UserInteraction {

	@Autowired
	private FeedbackToDatabaseService feedback;

	@Autowired
	public void setFeedback(IFeedback feedback) {
		this.feedback = (FeedbackToDatabaseService) feedback;
	}

	public UserInteraction() {
	}

	// Pour dire bonjour � l'utilisateur
	public void sayHello(String user) {
		Feedback newFeedback = new Feedback();
		newFeedback.setId(1);
		newFeedback.setUser("Nom");
		newFeedback.setMessage("Hello !");
		newFeedback.setEventTime(LocalDateTime.now());
	}

	// Pour dire aurevoir � l'utilisateur
	public void sayGoodBye(String user) {
		Feedback newFeedback = new Feedback();
		newFeedback.setId(1);
		newFeedback.setUser("Nom");
		newFeedback.setMessage("GoodBye !");
		newFeedback.setEventTime(LocalDateTime.now());
	}

	// Met a jour un bonjour existant par le message "Big up!"
	public void makeABetterHelloTo(String name) {
	}

	// Supprime tous les feedbacks avec un utilisateur
	public void deleteFeedbackWith(String name) {
	}

	// Récupère tous les feedbacks du jour pour un user
	public List<Feedback> listWhatWasSaidToHimToday(String name) {
	}

}
