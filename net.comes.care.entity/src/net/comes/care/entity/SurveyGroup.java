package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the survey_group database table.
 * 
 */
@Entity
@Table(name="survey_group")
public class SurveyGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private float weight;

	//bi-directional many-to-one association to SurveyQuestion
	@OneToMany(mappedBy="surveyGroup")
	private List<SurveyQuestion> surveyQuestions;

	public SurveyGroup() {
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

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public List<SurveyQuestion> getSurveyQuestions() {
		return this.surveyQuestions;
	}

	public void setSurveyQuestions(List<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}

}