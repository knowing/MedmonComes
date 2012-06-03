package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pat_answer database table.
 * 
 */
@Entity
@Table(name="pat_answer")
public class PatAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	@Column(name="answer_content")
	private String answerContent;

	@Column(name="answer_id")
	private int answerId;

	//bi-directional many-to-one association to SurveyQuestion
	@ManyToOne
	@JoinColumn(name="question_id")
	private SurveyQuestion surveyQuestion;

	//bi-directional many-to-one association to PatSurvey
	@ManyToOne
	@JoinColumn(name="pat_survey_id")
	private PatSurvey patSurvey;

	public PatAnswer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswerContent() {
		return this.answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public int getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public SurveyQuestion getSurveyQuestion() {
		return this.surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

	public PatSurvey getPatSurvey() {
		return this.patSurvey;
	}

	public void setPatSurvey(PatSurvey patSurvey) {
		this.patSurvey = patSurvey;
	}

}