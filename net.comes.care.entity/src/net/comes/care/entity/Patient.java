package net.comes.care.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	private int id;
	
	private String gender;
	
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	private String insurance;
	
	@Column(name = "insurance_number")
	private String insuranceNumber;
	
	@Lob
	private String freetext;
	
	@Column(length=30)
	private String country;
	
	@Column(length=50)
	private String street;
	
	@Column(length=5)
	private int zipcode;
	
	@Column(length=30)
	private String city;
	
	@Column(length=20)
	private String phone;
	
	@Column(length=20)
	private String mobile;
	
	@Column(length=20)
	private String fax;
	
	@Column(length=12)
	private int scancode;
	
	//Patient group
	
	@Column(name="pwd_client",length=45)
	private String pwdClient;
	
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH})
	private User user;
	
	public Patient() {
		//TODO Make tis constructor protected and remove new User()
		user = new User();
	}
	
	public Patient(User u) {
		this.user = u;
	}

	protected int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getFreetext() {
		return freetext;
	}

	public void setFreetext(String freetext) {
		this.freetext = freetext;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public int getScancode() {
		return scancode;
	}

	public void setScancode(int scancode) {
		this.scancode = scancode;
	}

	public String getPwdClient() {
		return pwdClient;
	}

	public void setPwdClient(String pwdClient) {
		this.pwdClient = pwdClient;
	}
	
	
	/* ============================= */
	/* ====== User delegates ======= */
	/* ============================= */

	public String getEmail() {
		return user.getEmail();
	}

	public void setEmail(String email) {
		user.setEmail(email);
	}

	public String getPwd() {
		return user.getPwd();
	}

	public void setPwd(String pwd) {
		user.setPwd(pwd);
	}

	public String getUserGroup() {
		return user.getUserGroup();
	}

	public void setUserGroup(String userGroup) {
		user.setUserGroup(userGroup);
	}

	public String getLanguage() {
		return user.getLanguage();
	}

	public void setLanguage(String language) {
		user.setLanguage(language);
	}

	public Date getLastLogin() {
		return user.getLastLogin();
	}

	public void setLastLogin(Date lastLogin) {
		user.setLastLogin(lastLogin);
	}

	public Date getCreated() {
		return user.getCreated();
	}

	public void setCreated(Date created) {
		user.setCreated(created);
	}

	public Date getExpire() {
		return user.getExpire();
	}

	public void setExpire(Date expire) {
		user.setExpire(expire);
	}

	public int getActive() {
		return user.getActive();
	}

	public void setActive(int active) {
		user.setActive(active);
	}

	public String getName() {
		return user.getName();
	}

	public void setName(String name) {
		user.setName(name);
	}

	public String getSurname() {
		return user.getSurname();
	}

	public void setSurname(String surname) {
		user.setSurname(surname);
	}

	public String getTitle() {
		return user.getTitle();
	}

	public void setTitle(String title) {
		user.setTitle(title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Patient [getId()=").append(getId()).append(", getName()=").append(getName()).append(", getSurname()=")
				.append(getSurname()).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Patient other = (Patient) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
