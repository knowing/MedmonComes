package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the survey_question database table.
 * 
 */
@Entity
@Table(name="survey_question")
public class SurveyQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String content;

	private int position;

	private float weight;

	//bi-directional many-to-one association to PatAnswer
	@OneToMany(mappedBy="surveyQuestion")
	private List<PatAnswer> patAnswers;

	//bi-directional many-to-one association to SurveyAnswer
	@OneToMany(mappedBy="surveyQuestion")
	private List<SurveyAnswer> surveyAnswers;

	//bi-directional many-to-one association to Survey
	@ManyToOne
	private Survey survey;

	//bi-directional many-to-one association to SurveyGroup
	@ManyToOne
	@JoinColumn(name="group_id")
	private SurveyGroup surveyGroup;

	public SurveyQuestion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public List<PatAnswer> getPatAnswers() {
		return this.patAnswers;
	}

	public void setPatAnswers(List<PatAnswer> patAnswers) {
		this.patAnswers = patAnswers;
	}

	public List<SurveyAnswer> getSurveyAnswers() {
		return this.surveyAnswers;
	}

	public void setSurveyAnswers(List<SurveyAnswer> surveyAnswers) {
		this.surveyAnswers = surveyAnswers;
	}

	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public SurveyGroup getSurveyGroup() {
		return this.surveyGroup;
	}

	public void setSurveyGroup(SurveyGroup surveyGroup) {
		this.surveyGroup = surveyGroup;
	}

}