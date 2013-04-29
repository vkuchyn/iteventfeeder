package ua.com.kuchyn.webinar.spring_hibernate.persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ua.com.kuchyn.webinar.spring_hibernate.model.Subscriber;

public class SubscriberPersistenceService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void subscribeEmail(String email, String tags) {
	sessionFactory.getCurrentSession().merge(new Subscriber(email, tags));
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Subscriber> getSybscribersByTag(String tag) {
	return sessionFactory.getCurrentSession()
		.createQuery("from Subscriber where tags like ?")
		.setParameter(0, "%" + tag + ",%").list();
	// .createCriteria(Subscriber.class)
	// .add(Restrictions.like("tags", "%" + tag + ",%")).list();
    }
}
