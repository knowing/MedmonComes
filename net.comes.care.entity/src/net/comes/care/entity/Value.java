package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the value database table.
 * 
 */
@Entity
public class Value implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date measuretime;

	@Column(name="patient_tag")
	private String patientTag;

	private float value;

	//bi-directional many-to-one association to Device
	@ManyToOne
	private Device device;

	//bi-directional many-to-one association to EquVal
	@ManyToOne
	@JoinColumn(name="equ_val_id")
	private EquVal equVal;

	public Value() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getMeasuretime() {
		return this.measuretime;
	}

	public void setMeasuretime(Date measuretime) {
		this.measuretime = measuretime;
	}

	public String getPatientTag() {
		return this.patientTag;
	}

	public void setPatientTag(String patientTag) {
		this.patientTag = patientTag;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public EquVal getEquVal() {
		return this.equVal;
	}

	public void setEquVal(EquVal equVal) {
		this.equVal = equVal;
	}

}