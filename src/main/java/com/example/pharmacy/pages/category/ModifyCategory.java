package com.example.pharmacy.pages.category;

import javax.inject.Inject;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

import com.example.pharmacy.entities.Category;



public class ModifyCategory {
	
	@Property
	@Persist
	private Category category;
	
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	@Inject
	private AlertManager alertManager;
	
	
	
	public Category findById(Long id) {

		if (id != null) {
			return (Category) session.get(Category.class, id);

		} else {
			return null;
		}

	}
	
	Object onActivate (Long id){
		category = findById(id);
		return null;
	}


	@CommitAfter
	Object onSuccess() {
		session.update(category);
		alertManager.info("The category is edited!!!");
		return null;

	}

}
