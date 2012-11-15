package com.example.pharmacy.pages.buyer;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.example.pharmacy.entities.Buyer;

public class AddBuyer {
	
	@Inject
	private Session session;
	
	@Persist
	@Property
	private Buyer buyer;
	
	@Inject
	private AlertManager manager;
	
	@CommitAfter
	Object onSuccess() {
		session.save(buyer);
		manager.info("You added new buyer");
		return null;
	}
	
}
