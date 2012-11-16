package com.example.pharmacy.pages.account;



import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;


import com.example.pharmacy.entities.User;
import com.example.pharmacy.pages.Index;
import com.example.pharmacy.services.Security;




public class Login {
	
	@Property
	private String userName;
	@Property
    private String password;
 
	@Inject
	private Session session;

	@SessionState
    private User user;
	
	@Inject
	private AlertManager alert;

	Object onSubmitFromLoginForm() {
		System.out.println("In login form submit event handler!");
		Class nextPage = null;
		User authenticatedUser = Security.authenticate(userName, password, session);
		if (authenticatedUser != null) {
		
			System.out.println("Authentication succeeded!");
			user = authenticatedUser;
			nextPage = Index.class;
		} else {
			System.out.println("Authentication failed!");
			alert.info("Wrong!");
			nextPage = Registraton.class;
		}
		
		return nextPage;
	}

}
