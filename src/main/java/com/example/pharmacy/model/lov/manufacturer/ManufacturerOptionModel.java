package com.example.pharmacy.model.lov.manufacturer;

import java.util.Map;

import org.apache.tapestry5.OptionModel;

import com.example.pharmacy.entities.Manufacturer;


public class ManufacturerOptionModel implements OptionModel{
	
	private Manufacturer manufacturer;

	public ManufacturerOptionModel(Manufacturer manufacturer) {
		super();
		this.manufacturer = manufacturer;
	}
	
	public Map<String, String> getAttributes() {
		return null;
	}

	public String getLabel() {		
		return this.manufacturer.getName();
	}

	public Object getValue() {
		return this.manufacturer;
	}

	public boolean isDisabled() {
		return false;
	}

}
