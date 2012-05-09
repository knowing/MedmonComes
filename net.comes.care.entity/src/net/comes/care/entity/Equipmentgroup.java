package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipmentgroup database table.
 * 
 */
@Entity
public class Equipmentgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to EquVal
	@OneToMany(mappedBy="equipmentgroup")
	private List<EquVal> equVals;

	//bi-directional many-to-one association to Equipment
	@OneToMany(mappedBy="equipmentgroup")
	private List<Equipment> equipments;

	public Equipmentgroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EquVal> getEquVals() {
		return this.equVals;
	}

	public void setEquVals(List<EquVal> equVals) {
		this.equVals = equVals;
	}

	public List<Equipment> getEquipments() {
		return this.equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

}