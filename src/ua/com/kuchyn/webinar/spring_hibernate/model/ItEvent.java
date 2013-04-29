package ua.com.kuchyn.webinar.spring_hibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "itevent")
@SequenceGenerator(name = "sequence", sequenceName = "itevent_id", allocationSize = 1)
public class ItEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private int id;

    private String description;

    private Date startDate;

    private ItEventType itEventType;

    public ItEvent() {
    }

    public ItEvent(String description, Date startDate, ItEventType itEventType) {
	super();
	this.description = description;
	this.startDate = startDate;
	this.itEventType = itEventType;
    }

    public ItEventType getItEventType() {
	return itEventType;
    }

    public void setItEventType(ItEventType itEventType) {
	this.itEventType = itEventType;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return "ItEvent [description=" + description + ", startDate="
		+ startDate + ", itEventType=" + itEventType + "]";
    }

}
