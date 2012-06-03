package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the privilege_group database table.
 * 
 */
@Entity
@Table(name="privilege_group")
public class PrivilegeGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String module;

	private String name;

	private String privilege;

	@Column(name="privilege_group_id")
	private String privilegeGroupId;

	private String reach;

	public PrivilegeGroup() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getPrivilegeGroupId() {
		return this.privilegeGroupId;
	}

	public void setPrivilegeGroupId(String privilegeGroupId) {
		this.privilegeGroupId = privilegeGroupId;
	}

	public String getReach() {
		return this.reach;
	}

	public void setReach(String reach) {
		this.reach = reach;
	}

}