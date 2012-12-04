package com.example.pharmacy.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "review_id")
	private Long id;
	@Validate("required")
	@Column(name = "comment", nullable = false)
	private String comment;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Validate("required")
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "review_user_id")
	private User user;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "order_product", joinColumns = { @JoinColumn(name = "review_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private Set<Products> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

}
