package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp date;

	@Lob
	private String message;

	@Temporal(TemporalType.TIMESTAMP)
	private Date readtime;

	private int status;

	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="recipient_id")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="creator_id")
	private User user2;

	public Message() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getReadtime() {
		return this.readtime;
	}

	public void setReadtime(Date readtime) {
		this.readtime = readtime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}