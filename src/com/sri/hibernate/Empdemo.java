package com.sri.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Empdemo {
	
	public static void main(String[] args) {
		
		SessionFactory sf=new AnnotationConfiguration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session s=sf.getCurrentSession();
		
		try{
			
			//create
			Employee e=new Employee("Dhanu","Jay","ONGC");
			s.beginTransaction();
			//s.save(e);
			
			//read
			String com="TCS";
			Employee r=(Employee) s.get(Employee.class, com);
			System.out.println(r.toString());
			
			//read-Query
			List<Employee> r1=s.createQuery("from Employee e where e.fn like '%ri' ").list();
			
			for(Employee em:r1){
				System.out.println(em.toString());
			}
			
			//delete
			s.createQuery("delete from Employee where c='TCS' ").executeUpdate();
			
			s.getTransaction().commit();
		}finally{
			sf.close();
		}
	}

}
