package com.example.pharmacy.model.lov.category;

import org.apache.tapestry5.ValueEncoder;
import org.hibernate.Session;

import com.example.pharmacy.entities.Category;


public class CategoryEncoder implements ValueEncoder{
	
	private Session session;

	public CategoryEncoder(Session session) {
		super();
		this.session = session;
	}
	
	public String toClient(Object arg0) {
		return ((Category)arg0).getId().toString();
	}

	public Object toValue(String arg0) {
		return session.load(Category.class, new Long(arg0));
	}

}
