package com.sri.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pswd="hr";
		
		try{
			System.out.println("Connecting to DB.......");
			Connection con=DriverManager.getConnection(url, user, pswd);
			System.out.println("Connection successfull!!");
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
