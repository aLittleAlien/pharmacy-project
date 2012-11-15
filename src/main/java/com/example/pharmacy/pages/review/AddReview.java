package com.example.pharmacy.pages.review;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.example.pharmacy.entities.Review;


public class AddReview {

	@Inject
	private Session session;
	
	@Inject
	private AlertManager man;
	
	@Property
	private Review review;
	
	
	@CommitAfter
	Object onSuccess(){
		session.save(review);
		man.info("You added new review!");
		return null;
	}
	

}
