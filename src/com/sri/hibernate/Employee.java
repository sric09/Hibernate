package com.sri.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Column(name="first_name")
	private String fn;
	
	@Column(name="last_name")
	private String ln;
	
	@Id
	@Column(name="company")
	private String c;
	
	public Employee(){
		
	}
	
	public Employee(String fn, String ln, String c){
		this.fn=fn;
		this.ln=ln;
		this.c=c;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Employee [fn=" + fn + ", ln=" + ln + ", c=" + c + "]";
	}
	
	
	

}
