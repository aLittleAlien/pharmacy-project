package com.example.pharmacy.pages.buyer;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.example.pharmacy.entities.Buyer;

public class EditBuyer {
	
	@Property
	@Persist
	private Buyer buyer;
	
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;
	
	@Inject
	private AlertManager alertManager;
	
	
	
	public Buyer findById(Long id) {

		if (id != null) {
			return (Buyer) session.get(Buyer.class, id);

		} else {
			return null;
		}

	}
	
	Object onActivate (Long id){
		buyer = findById(id);
		return null;
	}


	@CommitAfter
	Object onSuccess() {
		session.update(buyer);
		alertManager.info("The test is edited!!!");
		return null;

	}

}
