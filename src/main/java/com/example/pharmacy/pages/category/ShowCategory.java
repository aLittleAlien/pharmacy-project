package com.example.pharmacy.pages.category;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.example.pharmacy.entities.Category;


public class ShowCategory {
	
	@Inject
	private Session session;
	
	@Persist
	@Property
	private Category category;
	

	public List<Category> getCategories() {
		return session.createCriteria(Category.class).list();
	}
	
	public Category findById(Long id) {

		if (id != null) {
			return (Category) session.get(Category.class, id);

		} else {
			return null;
		}

	}


	@CommitAfter
	Object onActionFromDelete(Long tId) {
		Category t = findById(tId);
		session.delete(t);
		return null;

	}

}
