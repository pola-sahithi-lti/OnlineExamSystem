package com.example.demo.layer3;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Subject;

@Repository
public class BaseRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public BaseRepository() {
		System.out.println("BaseRepository()....");
	}
	
	@Transactional
	public void persist(Object obj) { //persist is a dummy/userdefined name
		
		try {
				entityManager.persist(obj);			
		} finally { entityManager.close(); }

	}
	
	@Transactional
	public <AnyClass> AnyClass find(Class<AnyClass> theClass, Serializable pk ) {
		AnyClass foundSavingsAccObj = null;
		try {			
			foundSavingsAccObj = entityManager.find(theClass, pk);	
		} finally { entityManager.close(); }
			return foundSavingsAccObj;
	}
	
	@Transactional
	public <E> List  findAll(String pojoName) {
		try {			
			Query query = entityManager.createQuery(" from "+ pojoName);
			return query.getResultList();
		} finally { entityManager.close(); }
	}
	
	@Transactional
	public void merge(Object obj) {
		
		try {
			entityManager.merge(obj); //<--real call for jdbc here		
		} finally { entityManager.close(); }
		
	}
	
	@Transactional
	public <AnyClass> void remove(Class<AnyClass> theClass, Serializable pk) {
	try {
		AnyClass anyClass = entityManager.find(theClass, pk);
		if(anyClass==null) {
			throw new RuntimeException("Object not found to delete");
		}
		entityManager.remove(anyClass);
		} finally { entityManager.close(); }
	}
	
	
	public Object findByLevelAndSubject(int level, String subject) {
		// TODO Auto-generated method stub
		try {
		
		Query query = entityManager.createQuery("SELECT s.subjectid FROM Subject s where s.levels="+level+" and s.subjects='"+subject+"'");
		return query.getSingleResult();
		} finally { entityManager.close(); }
	}
	
	public List<Subject> findByLevel(int level) {
		// TODO Auto-generated method stub
		try {
		
		Query query = entityManager.createQuery("SELECT s FROM Subject s where s.levels="+level);
		return query.getResultList();
		} finally { entityManager.close(); }
	}

}
