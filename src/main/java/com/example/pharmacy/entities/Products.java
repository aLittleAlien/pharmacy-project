package com.example.pharmacy.entities;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;


@Entity
@Table(name = "product")
public class Products {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	@NonVisual
	private Long id;
	@Validate("required")
	@Column(nullable = false, name = "name")
	private String name;
	@Validate("required")
	@Column(nullable = false, name = "code")
	private int code;
	
	@Validate("required")
	@Column(nullable = false, name = "company")
	private String  company;
	@Validate("required")
	@Column(nullable = false, name = "price")
	private double price; 
	@Validate("required") 
	@Column( name = "country")
	private String country;
	

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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	

}
