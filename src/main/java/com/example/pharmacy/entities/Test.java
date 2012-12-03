package com.example.pharmacy.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
@Table(name = "test")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "test_id")
	private Long id;
	@Validate("required")
	@Column(name = "name")
	private String name;
	@Validate("required")
	@Column(name = "lastname")
	private String lastName;
	@Validate("required")
	@Column(name = "username")
	private String username;
	@Validate("required")
	@Column(name = "password")
	private String password;
	@Validate("email,  required")
	@Column(name = "email")
	private String email;
	@Column(name = "age")
	private int age;
	
	
	private Date date;
	private String aboutMe;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
