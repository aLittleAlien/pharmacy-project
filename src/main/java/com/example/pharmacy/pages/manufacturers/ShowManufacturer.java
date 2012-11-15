package com.example.pharmacy.pages.manufacturers;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.example.pharmacy.entities.Manufacturer;



public class ShowManufacturer {
	
	@Inject
	private Session session;
	
	@Persist
	@Property
	private Manufacturer manufacturer;
	

	public List<Manufacturer> getManufacturers() {
		return session.createCriteria(Manufacturer.class).list();
	}
	
	public Manufacturer findById(Long id) {

		if (id != null) {
			return (Manufacturer) session.get(Manufacturer.class, id);

		} else {
			return null;
		}

	}


	@CommitAfter
	Object onActionFromDelete(Long tId) {
		Manufacturer t = findById(tId);
		session.delete(t);
		return null;

	}

}
