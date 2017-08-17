package com.app.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mappings.Course;
import com.mappings.Instructor;
import com.mappings.InstructorDetail;

public class InstructorDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sf=new AnnotationConfiguration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session s=sf.getCurrentSession();		
		
		try{
			
			Instructor tempIns=new Instructor("Chad", "Derby", "chad@luv2code.in");
			InstructorDetail tempDetail= new InstructorDetail("Udemy", "teaching");
			
			tempIns.setInstDetId(tempDetail);
			
			//to save data to DB
			s.beginTransaction();
			s.save(tempIns);
			s.getTransaction().commit();
			
			/*//to retrieve data from DB
			s.beginTransaction();
			int theId=500;
			InstructorDetail retDetail= (InstructorDetail) s.get(InstructorDetail.class, theId);
			
			System.out.println("Inst Detail "+retDetail);
			System.out.println("Associated Inst "+retDetail.getInstr());
			s.getTransaction().commit();*/
			
			/*//to delete
			s.beginTransaction();
			int theId=1050;
			InstructorDetail retDetail= (InstructorDetail) s.get(InstructorDetail.class, theId);
			
			System.out.println("Inst Detail "+retDetail);
			System.out.println("Associated Inst "+retDetail.getInstr());
			s.delete(retDetail);
			s.getTransaction().commit();*/
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			//s.close();
			sf.close();
			
		}
				
	}


}
