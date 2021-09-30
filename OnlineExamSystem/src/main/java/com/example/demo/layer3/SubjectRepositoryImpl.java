package com.example.demo.layer3;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Subject;

import net.bytebuddy.implementation.bind.annotation.Super;

@Repository
public class SubjectRepositoryImpl extends BaseRepository implements SubjectRepository {

	@Transactional
	public void insertSubject(Subject subRef) {
		super.persist(subRef);

	}

	@Transactional
	public Subject selectSubjectBySubjectId(int subId) {
		
		return super.find(Subject.class,subId);
		
	}

	@Transactional
	public List<Subject> selectAllSubject() {
		
		return super.findAll("Subject");
	}

	@Transactional
	public void updateSubject(Subject subRef) {
		super.merge(subRef);

	}

	@Transactional
	public void deleteSubject(int subId) {
		super.remove(Subject.class, subId);
	}

	@Override
	public Object findByLevelandSubject(int level, String subject) {
		return super.findByLevelAndSubject(level, subject);
	}
	
	
	
	@Transactional
	public List<Subject> findByLevel(int level)
	{
		return super.findByLevel(level);
	}

}
