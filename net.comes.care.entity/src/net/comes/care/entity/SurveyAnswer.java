package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the survey_answer database table.
 * 
 */
@Entity
@Table(name="survey_answer")
public class SurveyAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String content;

	private int position;

	private int value;

	//bi-directional many-to-one association to SurveyQuestion
	@ManyToOne
	@JoinColumn(name="question_id")
	private SurveyQuestion surveyQuestion;

	public SurveyAnswer() {
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

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SurveyQuestion getSurveyQuestion() {
		return this.surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

}