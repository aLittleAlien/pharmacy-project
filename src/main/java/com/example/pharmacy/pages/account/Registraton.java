package com.example.pharmacy.pages.account;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.example.pharmacy.entities.User;

public class Registraton {

	@Inject
	private Session session;
	
	@Property
	private User users;
	
	@Inject
	private AlertManager info;
	
	@Property
	private String password2;
	
	private Class nextPage = null;
	
	@CommitAfter
	Object onSuccess(){
		if(users.getPassword().equals(password2)){
			session.save(users);
			info.info("User is added!!!");
			nextPage = Login.class;
			return nextPage;
		}else{
			info.error("Wrong password!");
			nextPage = Registraton.class;
			return nextPage;
		}
	}
}
