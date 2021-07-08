package com.chandra.rest.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2, message = "Name should have atleat 2 characters")
	private String name;
	@Past
	private Date dob;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		
		return String.format("User [id=%s, name=%s, dob=%s]", id, name, dob);
		
	}
	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	public User() {
		super();
	}
	

}
