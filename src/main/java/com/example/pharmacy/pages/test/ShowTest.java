package com.example.pharmacy.pages.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.example.pharmacy.entities.Test;

public class ShowTest {
	
	@Inject
	private Session session;
	
	@Persist
	@Property
	private Test test;
	

	public List<Test> getTests() {
		return session.createCriteria(Test.class).list();
	}
	
	public Test findById(Long id) {

		if (id != null) {
			return (Test) session.get(Test.class, id);

		} else {
			return null;
		}

	}


	@CommitAfter
	Object onActionFromDelete(Long tId) {
		Test t = findById(tId);
		session.delete(t);
		return null;

	}
}
