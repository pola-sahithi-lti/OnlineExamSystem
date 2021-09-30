package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Subject;
import com.example.demo.layer4.SubjectService;

@CrossOrigin(origins = "*", value = "*")
@RestController
public class SubjectControllerImpl implements SubjectController {

	@Autowired
	SubjectService subjectService;
	
	
	@GetMapping
	@RequestMapping(path="/subject")
	public Subject selectSubjectByIdController() {
		Subject s =null;
		s= subjectService.findSubjectBySubjectId(2);
		System.out.println(s);
		return s;
	}


	@GetMapping
	@RequestMapping(path="/selectAllSubjects")
	public List<Subject> selectAllSubjectController() {
		System.out.println("Controller is called...");
		
		return subjectService.selectAllSubjectsService();
	}


	@PostMapping
	@RequestMapping(path="/addSubject")
	public void insertSubjectController(@RequestBody Subject subRef) {
		
		Subject s= new Subject();
		s.setSubjects(subRef.getSubjects());
		s.setLevels(subRef.getLevels());
		
		subjectService.insertSubjectService(s);
		
	}


	@PostMapping
	@RequestMapping(path="/deleteSubject")
	public void deleteSubjectController(@RequestBody Subject sub) {
		
		subjectService.deleteSubjectService(sub);
	}

	
//	@PostMapping
//	@RequestMapping(path="/modifySubject")
//	public void updateSubjectController(@RequestBody Subject subRef) {
//		
//		Subject s = new Subject();
//		s.setSubjectid(subRef.getSubjectid());
//		s.setSubjects(subRef.getSubjects());
//		s.setLevels(subRef.getLevels());
//		subjectService.updateSubjectService(subRef);
//		
//	}
	








}
