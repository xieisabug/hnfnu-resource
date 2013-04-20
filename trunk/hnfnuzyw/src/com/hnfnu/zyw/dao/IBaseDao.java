package com.hnfnu.zyw.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class IBaseDao {
	
private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
