package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the patient_group database table.
 * 
 */
@Entity
@Table(name="patient_group")
public class PatientGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="patientGroup")
	private List<Patient> patients;

	//bi-directional many-to-one association to Organisation
	@ManyToOne
	private Organisation organisation;

	public PatientGroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

}