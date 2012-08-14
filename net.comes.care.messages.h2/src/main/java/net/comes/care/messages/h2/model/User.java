package net.comes.care.messages.h2.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "User.byEmail", query = "SELECT u FROM User u WHERE u.email = :email") })
public class User {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Message> messages;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Message> getMessages() {
		return Collections.unmodifiableList(messages);
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public boolean addMessage(Message msg) {
		if (messages == null)
			setMessages(new LinkedList<Message>());
		msg.setUser(this);
		return messages.add(msg);
	}

	public boolean removeMessage(Message msg) {
		if (getMessages() == null)
			return false;
		msg.setUser(null);
		return messages.remove(msg);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
