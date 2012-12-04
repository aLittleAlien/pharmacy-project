package com.example.pharmacy.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "product_category_id")
	private Category category;

	@Validate("required")
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "product_manufacturer_id")
	private Manufacturer manufacturer;

	@Validate("required")
	@Column(nullable = false, name = "price")
	private double price;


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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
