package com.dto;

import javax.persistence.*;

@Entity
@Table(name="classes")
public class Classes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cid") 
	private int cid;
	
	@Column(name="class")
	private String classes;
	
	@Column(name="section")
	private String section;
	
	@Column(name="teacher")
	private String teacher;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="time")
	private String time;
	
	@Column(name="day")
	private  String day;
	
	public Classes() {
		
	}
	
	public Classes(String classes, String section, String teacher, String subject, String time, String day) {
		super();
		this.classes = classes;
		this.section = section;
		this.teacher = teacher;
		this.subject = subject;
		this.time = time;
		this.day = day;
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", classes=" + classes + ", section=" + section + ", teacher=" + teacher
				+ ", subject=" + subject + ", time=" + time + ", day=" + day + "]";
	}

}
