package com.sri.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Students")
public class Student {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTS_SEQU")
	@SequenceGenerator(name = "STUDENTS_SEQU", sequenceName = "STUDENTS_SEQ", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Column(name="first_name")
	private String fName;
	
	@Column(name="last_name")
	private String lName;
	
	@Column(name="email")
	private String email;
	
    @Column(name="dob")
    @Temporal(TemporalType.DATE)    
    private Date dateOfBirth;
	
	public Student(){
		
	}

	public Student(String fName, String lName, String email, Date dateOfBirth) {
		
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
	
	
	
	

}
