package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the SUBJECT database table.
 * 
 */
@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer subjectid;

	private Integer levels;

	private String subjects;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="subject", fetch=FetchType.LAZY)
	private List<Question> questions;

	//bi-directional many-to-one association to Scorecard
	@OneToMany(mappedBy="subject", fetch=FetchType.LAZY)
	private List<Scorecard> scorecards;

	public Subject() {
	}

	public Integer getSubjectid() {
		return this.subjectid;
	}

	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}

	public Integer getLevels() {
		return this.levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	public String getSubjects() {
		return this.subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	@JsonIgnore
	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setSubject(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setSubject(null);

		return question;
	}

	@JsonIgnore
	public List<Scorecard> getScorecards() {
		return this.scorecards;
	}

	public void setScorecards(List<Scorecard> scorecards) {
		this.scorecards = scorecards;
	}

	public Scorecard addScorecard(Scorecard scorecard) {
		getScorecards().add(scorecard);
		scorecard.setSubject(this);

		return scorecard;
	}

	public Scorecard removeScorecard(Scorecard scorecard) {
		getScorecards().remove(scorecard);
		scorecard.setSubject(null);

		return scorecard;
	}

}