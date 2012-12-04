package com.example.pharmacy.model.lov.category;

import java.util.Map;

import org.apache.tapestry5.OptionModel;

import com.example.pharmacy.entities.Category;

public class CategoryOptionModel implements OptionModel{

	private Category category;

	public CategoryOptionModel(Category category) {
		super();
		this.category = category;
	}
	
	public Map<String, String> getAttributes() {
		return null;
	}

	public String getLabel() {		
		return this.category.getName();
	}

	public Object getValue() {
		return this.category;
	}

	public boolean isDisabled() {
		return false;
	}
}
