package com.epam.hiber.program;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.epam.hiber.bean.User;

public class ReadObjectDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(User.class).
				buildSessionFactory();
		Session session =factory.getCurrentSession();
	try{
	
		session.beginTransaction();
		
		//Can use 'LIKE' with '%somevalue'
		List<User> userList=session.createQuery("from User u where u.login='max' OR u.login='testLogin'").getResultList();

		
		session.getTransaction().commit();
		System.out.println(userList);
	}finally {
		factory.close();
	}
	
	}

}
