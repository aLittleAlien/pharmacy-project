package com.example.pharmacy.pages.products;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.example.pharmacy.entities.Category;
import com.example.pharmacy.entities.Products;

public class ShowProducts{
	
	@Inject
	private Session session;
	
	@Persist
	@Property
	private Products product;
	

//	public List<Products> getProducts() {
//		return session.createCriteria(Products.class).list();
//	}
	
	public List<Products> getProducts() {
		return session.createCriteria(Products.class).list();
	}
	
//	public Products findById(Long id) {
//
//		if (id != null) {
//			return (Products) session.get(Products.class, id);
//
//		} else {
//			return null;
//		}
//
//	}
//
//
//	@CommitAfter
//	Object onActionFromDelete(Long tId) {
//		Products t = findById(tId);
//		session.delete(t);
//		return null;
//
//	}

}
