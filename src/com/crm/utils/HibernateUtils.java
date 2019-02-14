package com.crm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static {
		Configuration conf = new Configuration().configure();
		sessionFactory = conf.buildSessionFactory();
	}
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	public static void closeSessionFac() {
		sessionFactory.close();
	}
}
