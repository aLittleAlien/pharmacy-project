package com.example.pharmacy.model.lov.user;

import org.apache.tapestry5.ValueEncoder;
import org.hibernate.Session;

import com.example.pharmacy.entities.User;


public class UserEncoder implements ValueEncoder{
	
	private Session session;

	public UserEncoder(Session session) {
		super();
		this.session = session;
	}
	
	public String toClient(Object arg0) {
		return ((User)arg0).getId().toString();
	}

	public Object toValue(String arg0) {
		return session.load(User.class, new Long(arg0));
	}

}
