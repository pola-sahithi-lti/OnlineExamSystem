package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SCORECARD database table.
 * 
 */
@Entity
@NamedQuery(name="Scorecard.findAll", query="SELECT s FROM Scorecard s")
public class Scorecard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sno;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_EXAM")
	private Date dateOfExam;

	private Integer score;

	private String status;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="EMAIL")
	private Student student;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="SUBJECTID")
	private Subject subject;

	public Scorecard() {
	}

	public Integer getSno() {
		return this.sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Date getDateOfExam() {
		return this.dateOfExam;
	}

	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}