package com.example.pharmacy.pages.products;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.example.pharmacy.entities.Category;
import com.example.pharmacy.entities.Manufacturer;
import com.example.pharmacy.entities.Products;
import com.example.pharmacy.model.lov.category.CategoryEncoder;
import com.example.pharmacy.model.lov.category.CategorySelectModel;
import com.example.pharmacy.model.lov.manufacturer.ManufacturerEncoder;
import com.example.pharmacy.model.lov.manufacturer.ManufacturerSelectModel;
import com.example.pharmacy.pages.Index;

public class AddProduct {

	@Inject
	private Session session;

	@Property
	private Products product;

	@Persist
	@Property
	private Category selectedCategory;
	
	@Persist
	@Property
	private Manufacturer selectedManufacturer;
	
	@InjectPage
	private Index index;
	
	@Inject
	private AlertManager manager;

	public SelectModel getCategoryModel() {
		return new CategorySelectModel(session.createCriteria(Category.class)
				.list());
	}

	public ValueEncoder getCategoryEncoder() {
		return new CategoryEncoder(session);
	}
	
	
	public SelectModel getManufacturerModel() {
		return new ManufacturerSelectModel(session.createCriteria(Manufacturer.class)
				.list());
	}

	public ValueEncoder getManufacturerEncoder() {
		return new ManufacturerEncoder(session);
	}

	@CommitAfter
	Object onSuccess() {
		product.setCategory(selectedCategory);
		product.setManufacturer(selectedManufacturer);
		session.save(product);
		this.selectedCategory = null;
		this.selectedManufacturer = null;
		return index;

	}

}
