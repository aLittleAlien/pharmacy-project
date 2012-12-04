package com.example.pharmacy.pages.review;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.example.pharmacy.entities.Products;
import com.example.pharmacy.entities.Review;
import com.example.pharmacy.entities.User;
import com.example.pharmacy.model.lov.user.UserEncoder;
import com.example.pharmacy.model.lov.user.UserSelectModel;
import com.example.pharmacy.pages.Index;



public class AddReview {
	
	@Inject
	private Session session;
	@Property
	private Review review;
	@InjectPage
	private Index index;
	@Property
	private Set<Products> selectedProduct=new HashSet<Products>(0);; 
	@Property
	private Products rowProducts;
	@Persist
	@Property
	private User selectedUser;


	public SelectModel getUserModel() {
		return new UserSelectModel(session.createCriteria(User.class)
				.list());
	}

	public ValueEncoder getUserEncoder() {
		return new UserEncoder(session);
	}


	public List getProducts() {
		return session.createCriteria(Products.class).list();
	}

	
	@OnEvent(component = "selectedProduct")
	void selectProduct(Long id) {
		Products p = (Products) session.load(Products.class, new Long(id));
		selectedProduct.add(p);

	}

	@CommitAfter
	Object onSuccess() {
		String co = review.getComment();
		review = new Review();
		review.setComment(co);
		review.setUser(selectedUser);
		review.setProducts(selectedProduct);
		session.save(review);
		this.selectedUser = null;
		this.selectedProduct = null;

		return index;
	}

}
