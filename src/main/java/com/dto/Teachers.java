package com.dto;

import javax.persistence.*;

@Entity
@Table(name="teachers")
public class Teachers {
	
	@Id
	@Column(name="tid")
	private String tid;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="age")
	private String age;
	
	@Column(name="contact")
	private String contact;
	
	public Teachers() {
		
	}

	public Teachers(String tid, String fname, String lname, String age, String contact) {
		super();
		this.tid = tid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.contact = contact;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Teachers [tid=" + tid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", contact="
				+ contact + "]";
	}
	
	
	
	

}
