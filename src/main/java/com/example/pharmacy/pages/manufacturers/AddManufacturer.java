package com.example.pharmacy.pages.manufacturers;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.example.pharmacy.entities.Manufacturer;

public class AddManufacturer {
	
	@Inject
	private Session session;
	
	@Inject
	private AlertManager manager;
	
	@Property
	private Manufacturer manufacturer;
	
	@CommitAfter
	Object onSubmit() {
		session.save(manufacturer);
		manager.info("Manufacturer is added!");
		return null;
	}

}
