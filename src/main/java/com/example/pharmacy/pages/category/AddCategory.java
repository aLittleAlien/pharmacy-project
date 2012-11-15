package com.example.pharmacy.pages.category;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.example.pharmacy.entities.Category;


public class AddCategory {
	
	@Inject
	private Session session;

	@Persist
	@Property
	private Category category;

	@Inject
	private AlertManager manager;

	@CommitAfter
	Object onSuccess() {
		session.save(category);
		manager.info("Category is saved!!!");
		return null;

	}

}
