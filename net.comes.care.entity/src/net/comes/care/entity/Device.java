package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the device database table.
 * 
 */
@Entity
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="in_service")
	private byte inService;

	@Lob
	private String note;

	private String number;

	@Column(name="rfid_code")
	private String rfidCode;

	//bi-directional many-to-one association to DevKit
	@OneToMany(mappedBy="device")
	private List<DevKit> devKits;

	//bi-directional many-to-one association to Equipment
	@ManyToOne
	private Equipment equipment;

	//bi-directional many-to-one association to Value
	@OneToMany(mappedBy="device")
	private List<Value> values;

	public Device() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getInService() {
		return this.inService;
	}

	public void setInService(byte inService) {
		this.inService = inService;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRfidCode() {
		return this.rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	public List<DevKit> getDevKits() {
		return this.devKits;
	}

	public void setDevKits(List<DevKit> devKits) {
		this.devKits = devKits;
	}

	public Equipment getEquipment() {
		return this.equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public List<Value> getValues() {
		return this.values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

}