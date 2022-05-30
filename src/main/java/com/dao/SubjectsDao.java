package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.dto.Subjects;

public class SubjectsDao {
	
	public void addsub(String subjectname, String subcode) {
		
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration().configure();
			cfg.addAnnotatedClass(com.dto.Subjects.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			SessionFactory factory = cfg.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			tx = session.beginTransaction();
			Subjects subj = new Subjects(subjectname,subcode);
			session.save(subj);
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
