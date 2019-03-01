package com.epam.hiber.program;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.epam.hiber.bean.User;

public class SaveObjectDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(User.class).
				buildSessionFactory();
		Session session =factory.getCurrentSession();
	try{
		User user = new User("somelogin2","somepassword");
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
	}finally {
		factory.close();
	}
	
	}

}
