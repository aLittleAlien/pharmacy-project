package com.example.pharmacy.pages.buyer;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.hibernate.Session;

import com.example.pharmacy.entities.Buyer;
import com.example.pharmacy.pages.Base;

public class Details extends Base{
	
//	@Inject
//	private Session session;
	
	@Persist
//	@Property
	private Buyer buyer;

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
//	public List<Buyer> getBuyers() {
//		return session.createCriteria(Buyer.class).list();
//	}
	
	


}
