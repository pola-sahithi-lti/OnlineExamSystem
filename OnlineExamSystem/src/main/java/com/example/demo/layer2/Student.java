package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the STUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMAIL_ID")
	private String emailId;

	private String city;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	private String password;

	private String phonenumber;

	@Column(name="\"QUALIFICATION\"")
	private String qualification;

	@Column(name="\"STATE\"")
	private String state;

	private String username;

	private Integer yearofcompletion;

	//bi-directional many-to-one association to Scorecard
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER)
	private List<Scorecard> scorecards;

	public Student() {
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getYearofcompletion() {
		return this.yearofcompletion;
	}

	public void setYearofcompletion(Integer yearofcompletion) {
		this.yearofcompletion = yearofcompletion;
	}

	public List<Scorecard> getScorecards() {
		return this.scorecards;
	}

	public void setScorecards(List<Scorecard> scorecards) {
		this.scorecards = scorecards;
	}

	public Scorecard addScorecard(Scorecard scorecard) {
		getScorecards().add(scorecard);
		scorecard.setStudent(this);

		return scorecard;
	}

	public Scorecard removeScorecard(Scorecard scorecard) {
		getScorecards().remove(scorecard);
		scorecard.setStudent(null);

		return scorecard;
	}

}