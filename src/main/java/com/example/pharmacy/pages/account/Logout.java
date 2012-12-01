package com.example.pharmacy.pages.account;

import org.apache.tapestry5.annotations.SessionState;

import com.example.pharmacy.entities.User;
import com.example.pharmacy.pages.Index;



public class Logout {

	@SessionState
	private User user;

	public User getUser() {
		return user;
	}
	
	Object onActivate() {
		Class nextpage = Index.class;
		user = null;
		return nextpage;
	}

}
