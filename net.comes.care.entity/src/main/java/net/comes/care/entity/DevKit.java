package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dev_kit database table.
 * 
 */
@Entity
@Table(name="dev_kit")
public class DevKit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date begindate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;

	//bi-directional many-to-one association to Device
	@ManyToOne
	private Device device;

	//bi-directional many-to-one association to Measurementkit
	@ManyToOne
	private Measurementkit measurementkit;

	public DevKit() {
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

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Measurementkit getMeasurementkit() {
		return this.measurementkit;
	}

	public void setMeasurementkit(Measurementkit measurementkit) {
		this.measurementkit = measurementkit;
	}

}