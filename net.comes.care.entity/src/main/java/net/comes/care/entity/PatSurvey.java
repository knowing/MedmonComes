package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pat_survey database table.
 * 
 */
@Entity
@Table(name="pat_survey")
public class PatSurvey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date begindate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;

	//bi-directional many-to-one association to PatAnswer
	@OneToMany(mappedBy="patSurvey")
	private List<PatAnswer> patAnswers;

	//bi-directional many-to-one association to Survey
	@ManyToOne
	private Survey survey;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_creator_id")
	private User user;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	private Patient patient;

	public PatSurvey() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public List<PatAnswer> getPatAnswers() {
		return this.patAnswers;
	}

	public void setPatAnswers(List<PatAnswer> patAnswers) {
		this.patAnswers = patAnswers;
	}

	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}