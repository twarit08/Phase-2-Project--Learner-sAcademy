package com.dto;

import javax.persistence.*;

@Entity
@Table(name="subjclass")
public class SubjectClass {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subid")
	private int subid;
	
	@Column(name="subjectname")
	private String subjectname;
	
	@Column(name="subcode")
	private String subcode;
	
	@Column(name="class")
	private String classes;
	
	public SubjectClass() {
		
	}

	public SubjectClass(String subjectname, String subcode, String classes) {
		super();
		this.subjectname = subjectname;
		this.subcode = subcode;
		this.classes = classes;
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

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "SubjectClass [subid=" + subid + ", subjectname=" + subjectname + ", subcode=" + subcode + ", classes="
				+ classes + "]";
	}
	
	

}
