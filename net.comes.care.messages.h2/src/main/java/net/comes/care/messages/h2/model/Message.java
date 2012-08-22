package net.comes.care.messages.h2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.comes.care.ws.sycare.MessageType;

@Entity
@NamedQueries({
	@NamedQuery(name="Message.byUser", query="SELECT m FROM Message m WHERE m.user = :user"),
	@NamedQuery(name="Message.byUserAndMessageId", query="SELECT m FROM Message m WHERE m.user = :user AND m.messageId = :messageId")
})
public class Message {

	@Id
	@GeneratedValue
	private long id;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp = new Date();
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column
	private String sender;
	
	@Column
	private String messageType; //MessageType
	
	@Column
	private int messageId;
	
	@ManyToOne
	private User user;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getMessageType() {
		return messageType;
	}
	
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType.value();
	}

	public int getMessageId() {
		return messageId;
	}
	
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	
	public User getUser() {
		return user;
	}
	
	protected void setUser(User user) {
		this.user = user;
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
		Message other = (Message) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", timestamp=" + timestamp + ", title="
				+ title + ", content=" + content + ", sender=" + sender
				+ ", messageType=" + messageType + "]";
	}
	
	
	
}
