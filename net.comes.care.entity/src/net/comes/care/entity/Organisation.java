package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organisation database table.
 * 
 */
@Entity
public class Organisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="account_active")
	private int accountActive;

	private String city;

	private String country;

	private String fax;

	@Lob
	private String freetext;

	private String name;

	private String phone;

	private String street;

	private String website;

	private int zipcode;

	//bi-directional many-to-one association to KitOrg
	@OneToMany(mappedBy="organisation")
	private List<KitOrg> kitOrgs;

	//bi-directional many-to-one association to PatientGroup
	@OneToMany(mappedBy="organisation")
	private List<PatientGroup> patientGroups;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="organisation")
	private List<User> users;

	public Organisation() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public List<KitOrg> getKitOrgs() {
		return this.kitOrgs;
	}

	public void setKitOrgs(List<KitOrg> kitOrgs) {
		this.kitOrgs = kitOrgs;
	}

	public List<PatientGroup> getPatientGroups() {
		return this.patientGroups;
	}

	public void setPatientGroups(List<PatientGroup> patientGroups) {
		this.patientGroups = patientGroups;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}