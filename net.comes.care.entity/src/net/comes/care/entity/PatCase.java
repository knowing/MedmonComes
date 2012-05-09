package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pat_case database table.
 * 
 */
@Entity
@Table(name="pat_case")
public class PatCase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String creator;

	private String diag;

	@Temporal(TemporalType.TIMESTAMP)
	private Date diagtime;

	@Lob
	private String freetext;

	private byte height;

	private int number;

	private byte weight;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="user_patient_id")
	private Patient patient;

	public PatCase() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDiag() {
		return this.diag;
	}

	public void setDiag(String diag) {
		this.diag = diag;
	}

	public Date getDiagtime() {
		return this.diagtime;
	}

	public void setDiagtime(Date diagtime) {
		this.diagtime = diagtime;
	}

	public String getFreetext() {
		return this.freetext;
	}

	public void setFreetext(String freetext) {
		this.freetext = freetext;
	}

	public byte getHeight() {
		return this.height;
	}

	public void setHeight(byte height) {
		this.height = height;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public byte getWeight() {
		return this.weight;
	}

	public void setWeight(byte weight) {
		this.weight = weight;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}