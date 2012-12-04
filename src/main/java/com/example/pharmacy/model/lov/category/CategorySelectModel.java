package com.example.pharmacy.model.lov.category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

import com.example.pharmacy.entities.Category;



public class CategorySelectModel extends AbstractSelectModel{
	
	private Collection<Category> category; 

	public CategorySelectModel(Collection<Category> categories) {
		this.category = categories;
	}

	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		List<OptionModel> list = new ArrayList<OptionModel>();
		for (Category c : category) {
			list.add(new CategoryOptionModel(c));
		}
		return list;
	}

}
