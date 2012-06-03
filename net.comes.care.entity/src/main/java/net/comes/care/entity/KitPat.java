package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kit_pat database table.
 * 
 */
@Entity
@Table(name="kit_pat")
public class KitPat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date begindate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;

	//bi-directional many-to-one association to Measurementkit
	@ManyToOne
	private Measurementkit measurementkit;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="user_patient_id")
	private Patient patient;

	public KitPat() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Measurementkit getMeasurementkit() {
		return this.measurementkit;
	}

	public void setMeasurementkit(Measurementkit measurementkit) {
		this.measurementkit = measurementkit;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}