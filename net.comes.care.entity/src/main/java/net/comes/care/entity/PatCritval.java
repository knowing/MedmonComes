package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pat_critval database table.
 * 
 */
@Entity
@Table(name="pat_critval")
public class PatCritval implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="max_crit_value")
	private float maxCritValue;

	@Column(name="min_crit_value")
	private float minCritValue;

	//bi-directional many-to-one association to EquVal
	@ManyToOne
	@JoinColumn(name="equ_val_id")
	private EquVal equVal;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="patient_id1")
	private Patient patient;

	public PatCritval() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMaxCritValue() {
		return this.maxCritValue;
	}

	public void setMaxCritValue(float maxCritValue) {
		this.maxCritValue = maxCritValue;
	}

	public float getMinCritValue() {
		return this.minCritValue;
	}

	public void setMinCritValue(float minCritValue) {
		this.minCritValue = minCritValue;
	}

	public EquVal getEquVal() {
		return this.equVal;
	}

	public void setEquVal(EquVal equVal) {
		this.equVal = equVal;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}