package com.example.pharmacy.pages.account;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.example.pharmacy.entities.Products;
import com.example.pharmacy.entities.User;

public class Registraton {

	@Inject
	private Session session;
	
	@Property
	private User users;
	
	@CommitAfter
	Object onSuccess(){
		session.save(users);
		return null;
	}
}
