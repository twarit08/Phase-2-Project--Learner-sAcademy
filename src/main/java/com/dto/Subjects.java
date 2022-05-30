package com.dto;

import javax.persistence.*;

@Entity
@Table(name="subjects")
public class Subjects {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subid")
	private int subid;
	
	@Column(name="subcode")
	private String subcode;
	
	@Column(name="subjectname")
	private String subjectname;
	
	public Subjects() {
		
	}

	public Subjects(String subjectname, String subcode) {
		super();
		this.subjectname = subjectname;
		this.subcode = subcode;
	}
	
	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	@Override
	public String toString() {
		return "Subjects [subid=" + subid + ", subcode=" + subcode + ", subjectname=" + subjectname + "]";
	}

}
