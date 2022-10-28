package com.shivani.lab_5.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="student")
public class Student {
//id(primary key,auto incremented)book, author,

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String firstName;
	private String lastName;
	private String course;
	private String country;
	
	
	public Student() {
		
	}
	
	
	public Student(int id, String firstName, String lastName, String course,String country) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.country = country;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Student [id="+id+", firstName="+firstName+",lastName="+lastName+", course="+course+" , country="+country +"]";
	}
}
