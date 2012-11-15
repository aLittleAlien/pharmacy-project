package com.example.pharmacy.pages.test;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.example.pharmacy.entities.Test;

public class EditTest {
	
	@Property
	@Persist
	private Test test;
	
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	@Inject
	private AlertManager alertManager;
	
	
	
	public Test findById(Long id) {

		if (id != null) {
			return (Test) session.get(Test.class, id);

		} else {
			return null;
		}

	}
	
	Object onActivate (Long id){
		test = findById(id);
		return null;
	}


	@CommitAfter
	Object onSuccess() {
		session.update(test);
		alertManager.info("The test is edited!!!");
		return null;

	}
	
}
