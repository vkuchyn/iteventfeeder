package ua.com.kuchyn.webinar.spring_hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.kuchyn.webinar.spring_hibernate.model.ItEvent;
import ua.com.kuchyn.webinar.spring_hibernate.model.ItEventType;
import ua.com.kuchyn.webinar.spring_hibernate.service.ItEventService;

public class Main {

    public static void main(String[] args) throws ParseException {

	ApplicationContext context = new ClassPathXmlApplicationContext(
		"context.xml");

	ItEventService itEventService = context.getBean(ItEventService.class);
	// itEventService.subscribeEventType("kuchin.victor@gmail.com",
	// ItEventType.DOT_NET);

	ItEvent itBrunchEvent = new ItEvent("ITbrunch, .NET",
		getDate("18-05-2013 10:00"), ItEventType.DOT_NET);
	itEventService.addEvent(itBrunchEvent);
    }

    private static Date getDate(String dateString) throws ParseException {
	return new SimpleDateFormat("dd-MM-yyyy hh:mm").parse(dateString);
    }
}
