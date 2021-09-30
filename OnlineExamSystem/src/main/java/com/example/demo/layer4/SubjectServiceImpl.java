package com.example.demo.layer4;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Subject;
import com.example.demo.layer3.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectRepository subRepo;

	
	public Subject findSubjectBySubjectId(int subid) {
		Subject sub =null;
		sub = subRepo.selectSubjectBySubjectId(subid);
		
		return sub;
	}
	
	public List<Subject> selectAllSubjectsService(){
		return subRepo.selectAllSubject();
	}

	
	public void insertSubjectService(Subject sub) {
		subRepo.insertSubject(sub);
		
	}

	
	public void updateSubjectService(Subject sub) {
		subRepo.updateSubject(sub);
		
	}

	public void deleteSubjectService(Subject sub) {
		System.out.println("sub id"+ sub.getSubjectid());
		
		subRepo.deleteSubject(sub.getSubjectid());
		
	}
	
	

}
