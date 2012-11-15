package com.example.pharmacy.pages.products;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;


import com.example.pharmacy.entities.Products;

public class ModifyProduct {
	
	@Property
	@Persist
	private Products product;
	
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	@Inject
	private AlertManager alertManager;
	
	
	
	public Products findById(Long id) {

		if (id != null) {
			return (Products) session.get(Products.class, id);

		} else {
			return null;
		}

	}
	
	Object onActivate (Long id){
		product = findById(id);
		return null;
	}


	@CommitAfter
	Object onSuccess() {
		session.update(product);
		alertManager.info("The product is edited!!!");
		return null;

	}
	
}
