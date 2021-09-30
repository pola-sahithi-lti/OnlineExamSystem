package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Subject;

@Repository
public interface SubjectRepository {
	void insertSubject(Subject subRef);
	Subject selectSubjectBySubjectId(int subId);
	List<Subject> selectAllSubject();
	void updateSubject(Subject subRef);
	void deleteSubject(int subId);
	Object findByLevelandSubject(int level,String subject);
	List<Subject> findByLevel(int level);

}
