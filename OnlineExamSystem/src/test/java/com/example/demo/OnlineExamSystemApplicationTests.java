package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.Subject;

import com.example.demo.layer3.SubjectRepository;
import com.example.demo.layer4.SubjectService;

@SpringBootTest
class OnlineExamSystemApplicationTests {

	@Autowired
	SubjectRepository subRepo;
	
	@Autowired
	SubjectService subService;
	
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void insertSubject() {
		Subject sub = new Subject();
		sub.setSubjects("Python");
		sub.setLevels(1);
		subRepo.insertSubject(sub);
		
	}
	
	@Test 
	void selectAllSubjects()
	{
		List<Subject> subList;
		subList = subRepo.selectAllSubject();
		for(Subject sub:subList) {
			System.out.println("Subject Id:"+sub.getSubjectid());
			System.out.println("Subject Name:"+sub.getSubjects());
			System.out.println("Subject Level:"+sub.getLevels());
			System.out.println("=========");
		}	
	}
	
	@Test 
	void selectSubjectById(){
		Subject sub;
		sub=subRepo.selectSubjectBySubjectId(1);
		System.out.println("Subject Id:"+sub.getSubjectid());
		System.out.println("Subject Name:"+sub.getSubjects());
		System.out.println("Subject Level:"+sub.getLevels());
		System.out.println("=========");
	}
	
	@Test
	void updateSubject() {
		Subject sub;
		sub= subRepo.selectSubjectBySubjectId(29);
		sub.setLevels(3);
		subRepo.updateSubject(sub);
	}
	
	@Test
	void deleteSubject() {
		subRepo.deleteSubject(28);
	}
	
	@Test
	void findSubjectidByLevelandSubject() {
		int sub;
		sub = (int)subRepo.findByLevelandSubject(1, "Java");
		System.out.println("Subject id: "+sub);
	}
	
	@Test
	void findSubjectidByLevel() {
		List<Subject> subs;
		subs = subRepo.findByLevel(1);
		for(Subject s :subs) {
		System.out.println("Subject id: "+s.getSubjectid());
		}
	}
	
	@Test
	void selectAllSubjectServiceTest() {
		List<Subject> subList;
		subList = subService.selectAllSubjectsService();
		for(Subject sub:subList) {
			System.out.println("Subject Id:"+sub.getSubjectid());
			System.out.println("Subject Name:"+sub.getSubjects());
			System.out.println("Subject Level:"+sub.getLevels());
			System.out.println("=========");
		}	
	}
	
	
//	@Test
//	void insertUser() {
//		Userid u= new Userid();
//	}
	
//	@Test
//	void selectUserById() {
//		Userid user;
//		user=userRepo.selectUserById("sahithi@gmail.com");
//		System.out.println("S No: "+user.getSno());
//		System.out.println("User name:"+user.getStudent());
//		System.out.println("Password: "+user.getPassword());
//		System.out.println("=============");
//	}
	
	
//	@Test
//	void selectAllUsers() {
//		List<Userid> users;
//		users = userRepo.selectAllUsers();
//		for(Userid u : users) {
//			System.out.println("S No: "+u.getSno());
////			System.out.println("User name:"+u.getStudent());
//			System.out.println("Password: "+u.getPassword());
//			System.out.println("=============");
//			
//		}
//	}
	

}
