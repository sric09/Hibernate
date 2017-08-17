package com.app.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mappings.Course;
import com.mappings.Instructor;
import com.mappings.InstructorDetail;

public class CourseDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sf=new AnnotationConfiguration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session s=sf.getCurrentSession();		
		
		try{
			
			s.beginTransaction();
			/*int theId=50;
			Instructor temp=(Instructor) s.get(Instructor.class, theId);
			*/
			/*//add courses
			Course c1=new Course("Guitar");
			Course c2=new Course("Poker");
			
			temp.add(c1);
			temp.add(c2);
			
			s.save(c1);
			s.save(c2);*/
			
			/*//get courses
			System.out.println("Instructor "+temp);
			System.out.println("Courses "+temp.getCourses());*/
			
			//delete course
			int cid=10;
			Course c=(Course) s.get(Course.class, cid);
			
			s.delete(c);
			
			s.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			//s.close();
			sf.close();
			
		}
				
	}


}
