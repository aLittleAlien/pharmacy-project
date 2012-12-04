package com.example.pharmacy.model.lov.manufacturer;

import org.apache.tapestry5.ValueEncoder;
import org.hibernate.Session;

import com.example.pharmacy.entities.Manufacturer;


public class ManufacturerEncoder implements ValueEncoder{
	
	private Session session;

	public ManufacturerEncoder(Session session) {
		super();
		this.session = session;
	}
	
	public String toClient(Object arg0) {
		return ((Manufacturer)arg0).getId().toString();
	}

	public Object toValue(String arg0) {
		return session.load(Manufacturer.class, new Long(arg0));
	}

}
