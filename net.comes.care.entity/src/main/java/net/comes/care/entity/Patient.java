package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@Table(name="patient")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String city;

	private String country;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private String fax;

	@Lob
	private String freetext;

	private String gender;

	private String insurance;

	@Column(name="insurance_number")
	private String insuranceNumber;

	private String mobile;

	private String phone;

	@Column(name="pwd_client")
	private String pwdClient;

	private String street;

	private String tag;

	private int zipcode;

	//bi-directional many-to-one association to DoctorPatient
	@OneToMany(mappedBy="patient")
	private List<DoctorPatient> doctorPatients;

	//bi-directional many-to-one association to KitPat
	@OneToMany(mappedBy="patient")
	private List<KitPat> kitPats;

	//bi-directional many-to-one association to PatCase
	@OneToMany(mappedBy="patient")
	private List<PatCase> patCases;

	//bi-directional many-to-one association to PatCritval
	@OneToMany(mappedBy="patient")
	private List<PatCritval> patCritvals;

	//bi-directional many-to-one association to PatSurvey
	@OneToMany(mappedBy="patient")
	private List<PatSurvey> patSurveys;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private User user;

	//bi-directional many-to-one association to PatientGroup
	@ManyToOne
	@JoinColumn(name="patient_group_id")
	private PatientGroup patientGroup;

	public Patient() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFreetext() {
		return this.freetext;
	}

	public void setFreetext(String freetext) {
		this.freetext = freetext;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInsurance() {
		return this.insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getInsuranceNumber() {
		return this.insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwdClient() {
		return this.pwdClient;
	}

	public void setPwdClient(String pwdClient) {
		this.pwdClient = pwdClient;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public List<DoctorPatient> getDoctorPatients() {
		return this.doctorPatients;
	}

	public void setDoctorPatients(List<DoctorPatient> doctorPatients) {
		this.doctorPatients = doctorPatients;
	}

	public List<KitPat> getKitPats() {
		return this.kitPats;
	}

	public void setKitPats(List<KitPat> kitPats) {
		this.kitPats = kitPats;
	}

	public List<PatCase> getPatCases() {
		return this.patCases;
	}

	public void setPatCases(List<PatCase> patCases) {
		this.patCases = patCases;
	}

	public List<PatCritval> getPatCritvals() {
		return this.patCritvals;
	}

	public void setPatCritvals(List<PatCritval> patCritvals) {
		this.patCritvals = patCritvals;
	}

	public List<PatSurvey> getPatSurveys() {
		return this.patSurveys;
	}

	public void setPatSurveys(List<PatSurvey> patSurveys) {
		this.patSurveys = patSurveys;
	}

	public User getUser() {
		if(user == null)
			this.user = new User();
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PatientGroup getPatientGroup() {
		return this.patientGroup;
	}

	public void setPatientGroup(PatientGroup patientGroup) {
		this.patientGroup = patientGroup;
	}

}