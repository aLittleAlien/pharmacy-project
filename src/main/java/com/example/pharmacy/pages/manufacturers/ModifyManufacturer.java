package com.example.pharmacy.pages.manufacturers;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.example.pharmacy.entities.Manufacturer;



public class ModifyManufacturer {
	
	@Property
	@Persist
	private Manufacturer manufacturer;
	
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	@Inject
	private AlertManager alertManager;
	
	
	
	public Manufacturer findById(Long id) {

		if (id != null) {
			return (Manufacturer) session.get(Manufacturer.class, id);

		} else {
			return null;
		}

	}
	
	Object onActivate (Long id){
		manufacturer = findById(id);
		return null;
	}


	@CommitAfter
	Object onSuccess() {
		session.update(manufacturer);
		alertManager.info("The manufacturer is edited!!!");
		return null;

	}

}
