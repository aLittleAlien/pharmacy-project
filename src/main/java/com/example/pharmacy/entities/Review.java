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
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "id")
	private Long id;
	@Validate("required")
	@Column(name = "product", nullable = false)
	private String product;
	@Validate("required")
	@Column(name = "reviewnew", nullable = false)
	private String reviewnew;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getReviewnew() {
		return reviewnew;
	}
	public void setReviewnew(String reviewnew) {
		this.reviewnew = reviewnew;
	}
	
	

}
