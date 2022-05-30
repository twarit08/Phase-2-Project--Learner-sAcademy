package com.dto;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stid")
	private int stid;
	
	@Column(name="class")
	private String classes;
	
	@Column(name="rollno")
	private String rollno;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;

	@Column(name="section")
	private String section;
	
	@Column(name="age")
	private String age;
	
	public Students() {
		
	}

	public Students(String rollno, String fname, String lname, String classes, String section, String age) {
		super();
		this.rollno = rollno;
		this.fname = fname;
		this.lname = lname;
		this.classes = classes;
		this.section = section;
		this.age = age;
	}
	
	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Students [stid=" + stid + ", classes=" + classes + ", rollno=" + rollno + ", fname=" + fname
				+ ", lname=" + lname + ", section=" + section + ", age=" + age + "]";
	}

}
