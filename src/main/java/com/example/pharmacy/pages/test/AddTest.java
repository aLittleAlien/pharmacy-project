package com.example.pharmacy.pages.test;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.example.pharmacy.entities.Test;

public class AddTest {

	@Inject
	private Session session;

	@Property
	private Test test;

	@Inject
	private AlertManager manager;

	@CommitAfter
	Object onSuccess() {
		session.save(test);
		manager.info("Test is saved!!!!");
		return null;

	}

}
