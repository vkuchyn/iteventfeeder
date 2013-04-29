package ua.com.kuchyn.webinar.spring_hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subscriber")
@SequenceGenerator(name = "sequence", sequenceName = "subscriber_id", allocationSize = 1)
public class Subscriber {

    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    private int id;

    public Subscriber() {
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Subscriber other = (Subscriber) obj;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (tags == null) {
	    if (other.tags != null)
		return false;
	} else if (!tags.equals(other.tags))
	    return false;
	return true;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + id;
	result = prime * result + ((tags == null) ? 0 : tags.hashCode());
	return result;
    }

    String email;

    String tags;

    public Subscriber(String email, String tags) {
	super();
	this.email = email;
	this.tags = tags;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getTags() {
	return tags;
    }

    public void setTags(String tags) {
	this.tags = tags;
    }

    @Override
    public String toString() {
	return "Subscriber [id=" + id + ", email=" + email + ", tags=" + tags
		+ "]";
    }

}
