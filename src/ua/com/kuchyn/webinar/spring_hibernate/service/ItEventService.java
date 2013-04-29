package ua.com.kuchyn.webinar.spring_hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.kuchyn.webinar.spring_hibernate.model.ItEvent;
import ua.com.kuchyn.webinar.spring_hibernate.model.ItEventType;
import ua.com.kuchyn.webinar.spring_hibernate.model.Subscriber;
import ua.com.kuchyn.webinar.spring_hibernate.persistence.EventPersistenceService;
import ua.com.kuchyn.webinar.spring_hibernate.persistence.SubscriberPersistenceService;
import ua.com.kuchyn.webinar.spring_hibernate.service.mail.MailSender;

public class ItEventService {

    @Autowired
    private SubscriberPersistenceService subscriberPersistenceService;
    @Autowired
    private EventPersistenceService eventPersistenceService;
    @Autowired
    private MailSender mailSender;

    public void addEvent(ItEvent event) {
	eventPersistenceService.saveEvent(event);
	List<Subscriber> subscribers = subscriberPersistenceService
		.getSybscribersByTag(event.getItEventType().toString());
	for (Subscriber subscriber : subscribers) {
	    mailSender.sendMail(subscriber.getEmail(),
		    "New Event " + event.getDescription() + " will start on "
			    + event.getStartDate());
	}
	System.out.println("Event " + event + " was added");
    }

    public void subscribeEventType(String email, ItEventType... eventTypes) {
	System.out.println("User with email " + email + " was registered");
	StringBuilder tagsBuilder = new StringBuilder();
	for (ItEventType itEventType : eventTypes) {
	    tagsBuilder.append(itEventType.toString()).append(",");
	}
	subscriberPersistenceService.subscribeEmail(email,
		tagsBuilder.toString());
    }
}
