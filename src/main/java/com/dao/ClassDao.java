package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Classes;

public class ClassDao {
	
	public void register(String classes, String section, String teacher, String subject, String time, String day) {
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration().configure();
			cfg.addAnnotatedClass(com.dto.Classes.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
			SessionFactory factory = cfg.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			tx = session.beginTransaction();
			Classes cl = new Classes(classes,section,teacher,subject,time,day);
			session.save(cl);
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
