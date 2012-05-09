package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the doctor_patient database table.
 * 
 */
@Entity
@Table(name="doctor_patient")
public class DoctorPatient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="allow_messaging")
	private int allowMessaging;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_begin")
	private Date dateBegin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_end")
	private Date dateEnd;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="creator_id")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user2;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	private Patient patient;

	public DoctorPatient() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAllowMessaging() {
		return this.allowMessaging;
	}

	public void setAllowMessaging(int allowMessaging) {
		this.allowMessaging = allowMessaging;
	}

	public Date getDateBegin() {
		return this.dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
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

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}