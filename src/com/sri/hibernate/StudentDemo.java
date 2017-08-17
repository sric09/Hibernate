package com.sri.hibernate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class StudentDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sf=new AnnotationConfiguration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session s=sf.getCurrentSession();		
		
		try{
			
			/*//create
			String startDateString = "15/11/1990";
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			Date birthDate = null;
			try {
				birthDate = df.parse(startDateString);
			    String newDateString = df.format(birthDate);
			    System.out.println(newDateString);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			
			Student temp3=new Student("yagna","padma","yagna.p@gmail.com",birthDate);
			s.beginTransaction();
			s.save(temp3);
			s.getTransaction().commit();
			*/
			/*//read
			s=sf.getCurrentSession();
			s.beginTransaction();
			Student ms=(Student) s.get(Student.class, temp3.getId());
			System.out.println(ms.toString());
			s.getTransaction().commit();*/
			
			//Read query
			s=sf.getCurrentSession();
			s.beginTransaction();
			List<Student> sList=s.createQuery("from Student").list();
			//List<Student> sList=s.createSQLQuery("select * from STUDENTS").list();
			//List<Student> sList=s.createQuery("from Student st where st.lName='man' ").list();
			//List<Student> sList=s.createSQLQuery("from Students where last_name='man' ").list();
			displayStudents(sList);
			
			/*List<Student> sList2=s.createQuery("from Student st where st.fName='sri' and st.lName='dhar' ").list();
			displayStudents(sList2);*/
			
			/*//Update
			
			int sId=127,sId2=128;
			Student st=(Student) s.get(Student.class, sId);
			st.setEmail("sri@bns.com");*/
			
			/*//delete
			int sId2=127;
			Student st2=(Student) s.get(Student.class, sId2);
			s.delete(st2);
			s.getTransaction().commit();*/
			
			/*s.createQuery("delete from Student st where st.id=129").executeUpdate()				;
			s.getTransaction().commit();*/
			
			
		}finally{
			sf.close();
		}
				
	}

	private static void displayStudents(List<Student> sList) {
		for(Student st:sList){
			System.out.println(st.toString());
		}
	}

}
