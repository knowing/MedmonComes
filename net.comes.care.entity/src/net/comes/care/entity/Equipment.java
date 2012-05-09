package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipment database table.
 * 
 */
@Entity
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String manufacturer;

	private String name;

	private int number;

	//bi-directional many-to-one association to Device
	@OneToMany(mappedBy="equipment")
	private List<Device> devices;

	//bi-directional many-to-one association to Equipmentgroup
	@ManyToOne
	private Equipmentgroup equipmentgroup;

	public Equipment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Equipmentgroup getEquipmentgroup() {
		return this.equipmentgroup;
	}

	public void setEquipmentgroup(Equipmentgroup equipmentgroup) {
		this.equipmentgroup = equipmentgroup;
	}

}