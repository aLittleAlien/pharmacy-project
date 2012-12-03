package com.example.pharmacy.pages.buyer;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.hibernate.Session;

import com.example.pharmacy.entities.Buyer;

public class Details {
	
	@Inject
	private Session session;
	
	@Persist
	@Property
	private Buyer buyer;
	
	public List<Buyer> getBuyers() {
		return session.createCriteria(Buyer.class).list();
	}


}
