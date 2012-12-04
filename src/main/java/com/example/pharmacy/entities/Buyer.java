package com.example.pharmacy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
@Table(name="buyer")
public class Buyer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NonVisual
	@Column(name="buyer_id", nullable = false)
	private Long id;
	
	@Validate("required")
	@Column(name="name" , nullable = false)
	private String name;
	
	@Validate("required")
	@Column(name="lastname" , nullable = false)
	private String lastname;
	
	@Validate("email, required")
	@Column(name="email", nullable = false)
	private String email;
	
	@Validate("required")
	@Column(name="username" , nullable = false)
	private String username;
	
	@Validate("required")
	@Column(name="password" , nullable = false)
	private String password;
	
	@Column(name="age", nullable = false)
	private int age;
	private String aboutMe;

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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

}
