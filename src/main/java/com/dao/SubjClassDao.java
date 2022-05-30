package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.dto.SubjectClass;

public class SubjClassDao {
	
	public void assign(String subname,String subcode,String classes) {
		
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration().configure();
			cfg.addAnnotatedClass(com.dto.SubjectClass.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			SessionFactory factory = cfg.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			tx = session.beginTransaction();
			SubjectClass sc = new SubjectClass(subname,subcode,classes);
			session.save(sc);
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
