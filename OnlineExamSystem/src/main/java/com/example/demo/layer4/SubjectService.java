package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Subject;

@Service
public interface SubjectService {
	
	public Subject findSubjectBySubjectId(int subid) ;

	public List<Subject> selectAllSubjectsService();
	
	public void insertSubjectService(Subject sub);
	
	public void updateSubjectService(Subject sub);
	
	public void deleteSubjectService(Subject sub);
	

}
