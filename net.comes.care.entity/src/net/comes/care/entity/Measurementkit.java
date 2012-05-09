package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the measurementkit database table.
 * 
 */
@Entity
public class Measurementkit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="in_service")
	private byte inService;

	@Lob
	private String notes;

	private int number;

	@Column(name="rfid_code")
	private String rfidCode;

	//bi-directional many-to-one association to DevKit
	@OneToMany(mappedBy="measurementkit")
	private List<DevKit> devKits;

	//bi-directional many-to-one association to KitOrg
	@OneToMany(mappedBy="measurementkit")
	private List<KitOrg> kitOrgs;

	//bi-directional many-to-one association to KitPat
	@OneToMany(mappedBy="measurementkit")
	private List<KitPat> kitPats;

	public Measurementkit() {
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

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
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

	public List<KitOrg> getKitOrgs() {
		return this.kitOrgs;
	}

	public void setKitOrgs(List<KitOrg> kitOrgs) {
		this.kitOrgs = kitOrgs;
	}

	public List<KitPat> getKitPats() {
		return this.kitPats;
	}

	public void setKitPats(List<KitPat> kitPats) {
		this.kitPats = kitPats;
	}

}