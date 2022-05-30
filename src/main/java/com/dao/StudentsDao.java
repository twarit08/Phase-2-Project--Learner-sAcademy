package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Students;

public class StudentsDao {
	
	public void enroll(String rollno, String fname, String lname, String classes, String section, String age) {
		
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration().configure();
			cfg.addAnnotatedClass(com.dto.Students.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			SessionFactory factory = cfg.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			tx = session.beginTransaction();
			Students st = new Students(rollno,fname,lname,classes,section,age);
			session.save(st);
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}
		
	}

}
