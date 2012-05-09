package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="account_active")
	private int accountActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_created")
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	@Column(name="date_expire")
	private Date dateExpire;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_lastlogin")
	private Date dateLastlogin;

	private String email;

	private String language;

	private String name;

	private String pwd;

	@Column(name="session_id")
	private String sessionId;

	private String surname;

	private String title;

	@Column(name="user_group")
	private String userGroup;

	//bi-directional many-to-one association to AuditLog
	@OneToMany(mappedBy="user")
	private List<AuditLog> auditLogs;

	//bi-directional many-to-one association to DoctorPatient
	@OneToMany(mappedBy="user1")
	private List<DoctorPatient> doctorPatients1;

	//bi-directional many-to-one association to DoctorPatient
	@OneToMany(mappedBy="user2")
	private List<DoctorPatient> doctorPatients2;

	//bi-directional many-to-one association to Log
	@OneToMany(mappedBy="user")
	private List<Log> logs;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user2")
	private List<Message> messages2;

	//bi-directional many-to-one association to PatSurvey
	@OneToMany(mappedBy="user")
	private List<PatSurvey> patSurveys;

	//bi-directional one-to-one association to Patient
	@OneToOne(mappedBy="user")
	private Patient patient;

	//bi-directional many-to-one association to Privilege
	@OneToMany(mappedBy="user")
	private List<Privilege> privileges;

	//bi-directional many-to-one association to SoapSession
	@OneToMany(mappedBy="user")
	private List<SoapSession> soapSessions;

	//bi-directional many-to-one association to Survey
	@OneToMany(mappedBy="user")
	private List<Survey> surveys;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	@JoinColumn(name="organisations_id")
	private Organisation organisation;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountActive() {
		return this.accountActive;
	}

	public void setAccountActive(int accountActive) {
		this.accountActive = accountActive;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateExpire() {
		return this.dateExpire;
	}

	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
	}

	public Date getDateLastlogin() {
		return this.dateLastlogin;
	}

	public void setDateLastlogin(Date dateLastlogin) {
		this.dateLastlogin = dateLastlogin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public List<AuditLog> getAuditLogs() {
		return this.auditLogs;
	}

	public void setAuditLogs(List<AuditLog> auditLogs) {
		this.auditLogs = auditLogs;
	}

	public List<DoctorPatient> getDoctorPatients1() {
		return this.doctorPatients1;
	}

	public void setDoctorPatients1(List<DoctorPatient> doctorPatients1) {
		this.doctorPatients1 = doctorPatients1;
	}

	public List<DoctorPatient> getDoctorPatients2() {
		return this.doctorPatients2;
	}

	public void setDoctorPatients2(List<DoctorPatient> doctorPatients2) {
		this.doctorPatients2 = doctorPatients2;
	}

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public List<PatSurvey> getPatSurveys() {
		return this.patSurveys;
	}

	public void setPatSurveys(List<PatSurvey> patSurveys) {
		this.patSurveys = patSurveys;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Privilege> getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public List<SoapSession> getSoapSessions() {
		return this.soapSessions;
	}

	public void setSoapSessions(List<SoapSession> soapSessions) {
		this.soapSessions = soapSessions;
	}

	public List<Survey> getSurveys() {
		return this.surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

}