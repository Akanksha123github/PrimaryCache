package com.h2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Student stu = (Student) session.load(Student.class,1);
		System.out.println(stu.getId()+" "+stu.getName()+" "+stu.getCity()+" "+stu.getMobile());
		//Query will be writen only one time....
		//same Data will try to fetch so it will take from the cache not from DB
		
		Student stu1 = (Student) session.load(Student.class,1);
		System.out.println(stu1.getId()+" "+stu1.getName()+" "+stu1.getCity()+" "+stu1.getMobile());
		

	}

}
