package com.mappings;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTR_SEQ")
	@SequenceGenerator(name="INSTR_SEQ", sequenceName="INST_SEQ")
	private int id;
	
	@Column(name="first_name")
	private String fName;
	
	@Column(name="last_name")
	private String lName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="inst_det_id")
	private InstructorDetail instDetId;
	
	@OneToMany(mappedBy="inst", cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Course> courses;
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void add(Course tempCourse){
		
		if(courses==null){
			courses=new ArrayList<>();
		}
		
		courses.add(tempCourse);
		
		tempCourse.setInst(this);
	}

	public Instructor() {
	}

	public Instructor(String fName, String lName, String email) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		
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

	public InstructorDetail getInstDetId() {
		return instDetId;
	}

	public void setInstDetId(InstructorDetail instDetId) {
		this.instDetId = instDetId;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", instDetId="
				+ instDetId + "]";
	}
	
	
}
