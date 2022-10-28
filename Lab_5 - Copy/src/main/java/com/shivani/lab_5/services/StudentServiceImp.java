package com.shivani.lab_5.services;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import javax.websocket.Session;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivani.lab_5.entity.Student;



@Repository
public class StudentServiceImp implements StudentService {
	
	private org.hibernate.Session session;
	
	   @Autowired
    StudentServiceImp(SessionFactory sessionFactory){
		try {
			session = sessionFactory.getCurrentSession();
		}catch(HibernateException e) {
			session =sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Student> findAll(){
		org.hibernate.Transaction tx = session.beginTransaction();
		
		List<Student> student=session.createQuery("from Student").list();
		
		tx.commit();
		
		return student;
		
	}
	
	@Transactional
	public Student findById(int id) {
		
		Student student = new Student();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		student = session.get(Student.class, id);
		
		tx.commit();
		
		return student;
	}
	
	@Transactional
	public void save(Student theStudent) {
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(theStudent);
		tx.commit();
	}

	@Transactional
	public void deleteById(int id) {
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Student student = session.get(Student.class, id);
		
		session.delete(student);
	
		tx.commit();
	}

	@Override
	public Student findbyId(int theId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}


