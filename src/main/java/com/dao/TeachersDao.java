package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Teachers;

public class TeachersDao {
	
	public void addTeacher(String tid, String fname, String lname, String age, String contact) {
		
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration().configure();
			cfg.addAnnotatedClass(com.dto.Teachers.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			SessionFactory factory = cfg.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			tx = session.beginTransaction();
			Teachers t = new Teachers(tid,fname,lname,age,contact);
			session.save(t);
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
