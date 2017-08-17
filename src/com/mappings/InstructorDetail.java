package com.mappings;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTR_DET_SEQ")
	@SequenceGenerator(name="INSTR_DET_SEQ", sequenceName="INST_DET_SEQ")
	private int id;
	
	@Column(name="video_channel")
	private String vChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	//add Instructor field for bidirectional mapping
	@OneToOne(mappedBy="instDetId", cascade=CascadeType.ALL)
	private Instructor instr;
	
	public Instructor getInstr() {
		return instr;
	}

	public void setInstr(Instructor instr) {
		this.instr = instr;
	}

	public InstructorDetail() {
	}
	
	public InstructorDetail(String vChannel, String hobby) {
		this.vChannel = vChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getvChannel() {
		return vChannel;
	}

	public void setvChannel(String vChannel) {
		this.vChannel = vChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", vChannel=" + vChannel + ", hobby=" + hobby + "]";
	}
	
	

}
