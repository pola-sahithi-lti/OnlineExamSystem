package com.example.demo.layer5;

import java.util.List;

import com.example.demo.layer2.Subject;

public interface SubjectController {
	
	public Subject selectSubjectByIdController();
	public List<Subject> selectAllSubjectController();
	public void insertSubjectController(Subject subRef);
//	public void updateSubjectController(Subject subRef);
	
	public void deleteSubjectController(Subject subRef);
	

}
