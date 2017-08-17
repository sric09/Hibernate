package com.mappings;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CG")
	@SequenceGenerator(name="CG", sequenceName="course_seq", allocationSize=1, initialValue=10)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="inst_id")
	private Instructor inst;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Instructor getInst() {
		return inst;
	}
	public void setInst(Instructor inst) {
		this.inst = inst;
	}
	public Course(String title) {
		this.title = title;
	}
	public Course() {
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	

}
