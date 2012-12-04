package com.example.pharmacy.pages.reservation;

import java.util.Collection;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.example.pharmacy.entities.Products;
import com.example.pharmacy.entities.Reservation;
import com.example.pharmacy.pages.Base;

public class ShowReservation extends Base{

	@Inject
	private Session session;

	
	@Property
	@Persist
	private Reservation rowReservation;
	@Property
	@Persist
	private Products rowProducts;
	
	public Collection<Reservation> getReservationsCollection() {
		return session.createCriteria(Reservation.class).addOrder( Order.asc("id") ).list();
	}
}
