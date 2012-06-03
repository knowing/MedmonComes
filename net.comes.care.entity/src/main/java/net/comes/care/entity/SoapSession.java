package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the soap_session database table.
 * 
 */
@Entity
@Table(name="soap_session")
public class SoapSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int session;

	@Temporal(TemporalType.DATE)
	@Column(name="valid_until")
	private Date validUntil;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public SoapSession() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSession() {
		return this.session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public Date getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}