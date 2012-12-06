package com.example.pharmacy.pages.buyer;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.example.pharmacy.entities.Buyer;

public class ShowBuyer {
	
	@Inject
	private Session session;
	
	@Persist
	@Property
	private Buyer buyer;
	
	public List<Buyer> getBuyers() {
		return session.createCriteria(Buyer.class).list();
	}
	
	public Buyer findById(Long id) {

		if (id != null) {
			return (Buyer) session.get(Buyer.class, id);

		} else {
			return null;
		}

	}


	@CommitAfter
	Object onActionFromDelete(Long tId) {
		Buyer b = findById(tId);
		session.delete(b);
		return null;

	}
	
	

}
