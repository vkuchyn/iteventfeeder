package ua.com.kuchyn.webinar.spring_hibernate.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.com.kuchyn.webinar.spring_hibernate.model.ItEvent;

public class EventPersistenceService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveEvent(ItEvent event) {
	sessionFactory.getCurrentSession().merge(event);
    }

}
