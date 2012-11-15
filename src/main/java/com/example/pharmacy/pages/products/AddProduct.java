package com.example.pharmacy.pages.products;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;


import com.example.pharmacy.entities.Products;

public class AddProduct {
	
	@Inject
	private Session session;

	@Persist
	@Property
	private Products product;

	@Inject
	private AlertManager manager;

	@CommitAfter
	Object onSuccess() {
		session.save(product);
		manager.info("Product is saved!!!");
		return null;

	}

}
