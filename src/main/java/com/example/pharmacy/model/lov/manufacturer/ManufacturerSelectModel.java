package com.example.pharmacy.model.lov.manufacturer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

import com.example.pharmacy.entities.Manufacturer;



public class ManufacturerSelectModel extends AbstractSelectModel{
	
	private Collection<Manufacturer> manufacturer; 

	public ManufacturerSelectModel(Collection<Manufacturer> manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		List<OptionModel> list = new ArrayList<OptionModel>();
		for (Manufacturer m : manufacturer) {
			list.add(new ManufacturerOptionModel(m));
		}
		return list;
	}

}
