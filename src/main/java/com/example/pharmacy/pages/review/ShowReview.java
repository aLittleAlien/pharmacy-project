package com.example.pharmacy.pages.review;

import java.util.Collection;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.example.pharmacy.entities.Products;
import com.example.pharmacy.entities.Review;
import com.example.pharmacy.pages.Base;

public class ShowReview extends Base{
	
	@Inject
	private Session session;

	
	@Property
	@Persist
	private Review rowReview;
	@Property
	@Persist
	private Products rowProducts;
	
	public Collection<Review> getReviewsCollection() {
		return session.createCriteria(Review.class).addOrder( Order.asc("id") ).list();
	}
	

}
