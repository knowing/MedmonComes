package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the privilege database table.
 * 
 */
@Entity
public class Privilege implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String module;

	private String privilege;

	private String reach;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Privilege() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getReach() {
		return this.reach;
	}

	public void setReach(String reach) {
		this.reach = reach;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}