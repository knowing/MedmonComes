package net.comes.care.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=40)
	private String email;
	
	@Column(length=32)
	private String pwd;
	
	@Column(name="user_group",length=40)
	private String userGroup;
	
	@Column(length=2)
	private String language;

	@Column(name="date_lastlogin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	
	@Column(name="date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Column(name="date_expire")
	@Temporal(TemporalType.DATE)
	private Date expire;
	
	//organisation id
	

	@Column(name="account_active", length=1)
	private int active;
	
	@Column(length=30)
	private String name;
	

	@Column(length=30)
	private String surname;
	

	@Column(length=20)
	private String title;

	//session id

	protected int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getUserGroup() {
		return userGroup;
	}


	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Date getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getExpire() {
		return expire;
	}


	public void setExpire(Date expire) {
		this.expire = expire;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
}
