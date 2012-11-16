package com.example.pharmacy.pages.account;

import org.apache.tapestry5.annotations.SessionState;

import com.example.pharmacy.entities.User;



public class Logout {

	@SessionState
	private User user;

	public User getUser() {
		return user;
	}
	
	Object onActivate() {
		user = null;
		return null;
	}

}
