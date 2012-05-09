package net.comes.care.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the survey database table.
 * 
 */
@Entity
public class Survey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String freetext;

	private String title;

	//bi-directional many-to-one association to PatSurvey
	@OneToMany(mappedBy="survey")
	private List<PatSurvey> patSurveys;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="creator_id")
	private User user;

	//bi-directional many-to-one association to SurveyQuestion
	@OneToMany(mappedBy="survey")
	private List<SurveyQuestion> surveyQuestions;

	public Survey() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFreetext() {
		return this.freetext;
	}

	public void setFreetext(String freetext) {
		this.freetext = freetext;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PatSurvey> getPatSurveys() {
		return this.patSurveys;
	}

	public void setPatSurveys(List<PatSurvey> patSurveys) {
		this.patSurveys = patSurveys;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SurveyQuestion> getSurveyQuestions() {
		return this.surveyQuestions;
	}

	public void setSurveyQuestions(List<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}

}