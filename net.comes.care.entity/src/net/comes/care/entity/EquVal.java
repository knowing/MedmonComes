package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equ_val database table.
 * 
 */
@Entity
@Table(name="equ_val")
public class EquVal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte decimals;

	private String description;

	@Column(name="max_value")
	private float maxValue;

	@Column(name="min_value")
	private float minValue;

	private String unit;

	@Column(name="value_code")
	private int valueCode;

	//bi-directional many-to-one association to Equipmentgroup
	@ManyToOne
	private Equipmentgroup equipmentgroup;

	//bi-directional many-to-one association to PatCritval
	@OneToMany(mappedBy="equVal")
	private List<PatCritval> patCritvals;

	//bi-directional many-to-one association to Value
	@OneToMany(mappedBy="equVal")
	private List<Value> values;

	public EquVal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getDecimals() {
		return this.decimals;
	}

	public void setDecimals(byte decimals) {
		this.decimals = decimals;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}

	public float getMinValue() {
		return this.minValue;
	}

	public void setMinValue(float minValue) {
		this.minValue = minValue;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getValueCode() {
		return this.valueCode;
	}

	public void setValueCode(int valueCode) {
		this.valueCode = valueCode;
	}

	public Equipmentgroup getEquipmentgroup() {
		return this.equipmentgroup;
	}

	public void setEquipmentgroup(Equipmentgroup equipmentgroup) {
		this.equipmentgroup = equipmentgroup;
	}

	public List<PatCritval> getPatCritvals() {
		return this.patCritvals;
	}

	public void setPatCritvals(List<PatCritval> patCritvals) {
		this.patCritvals = patCritvals;
	}

	public List<Value> getValues() {
		return this.values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

}