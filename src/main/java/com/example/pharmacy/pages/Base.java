package com.example.pharmacy.pages;

import org.apache.tapestry5.annotations.SessionState;

import com.example.pharmacy.entities.User;
import com.example.pharmacy.pages.account.Login;



public class Base {
	
	@SessionState
	private User user;
	private boolean userExists;

	public User getUser() {
		return user;
	}

	Object onActivate() {
		if (!userExists)
			return Login.class;
		return null;
	}

}
