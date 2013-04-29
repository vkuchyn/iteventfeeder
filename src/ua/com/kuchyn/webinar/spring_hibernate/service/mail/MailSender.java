package ua.com.kuchyn.webinar.spring_hibernate.service.mail;

public class MailSender {

    public void sendMail(String email, String text) {
	System.out.println("Mail with text " + text + " was sent to " + email);
    }

}
