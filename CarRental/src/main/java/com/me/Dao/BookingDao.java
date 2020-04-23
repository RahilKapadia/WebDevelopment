package com.me.Dao;
import org.hibernate.HibernateException;
import java.util.List;
import java.util.Date;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import com.me.pojo.Booking;
import com.me.pojo.Car;
import com.me.pojo.Customer;
public class BookingDao extends DAO {

	
public boolean addBooking (Car car, Customer customer, int oid, Date startdate, Date enddate, int amount) {
	
	try {
		
		Booking book = new Booking();
		book.setCar(car);
		book.setCustomer(customer);
		book.setStartDate(startdate);
		book.setEndDate(enddate);
		book.setOwnerId(oid);
		book.setBookingAmount(amount);
		book.setStatus("active");
	      
		begin();
		getSession().save(book);
		commit();
		
		return true;
		}
	catch(HibernateException e) {
		e.printStackTrace();
		rollback();
		return false;
		
	}
	finally {
	close();

	}
}
	


public List<Booking> getByOwner(int id){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class);
	crit.add(Restrictions.eq("OwnerId", id));
	crit.add(Restrictions.eq("Status", "active"));
	List<Booking> getbyowner = crit.list();
	commit();
	close();
	return getbyowner;

}

public List<Booking> getByCustomer(Customer cust){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class);
	crit.add(Restrictions.eq("customer", cust));
	crit.add(Restrictions.eq("Status", "active"));
	List<Booking> getbycustomer = crit.list();
	commit();
	close();
	return getbycustomer;

}

public List<Booking> getByCar(Car car){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class);
	crit.add(Restrictions.eq("car", car));
	crit.add(Restrictions.eq("Status", "active"));
	List<Booking> getbycar = crit.list();
	commit();
	close();
	return getbycar;

}





public List<Booking> getBookings(){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class,"book");
	crit.createAlias("book.car", "car");
	crit.add(Restrictions.eq("car.status", "active"));
	crit.add(Restrictions.eq("book.Status", "active"));
	
	List<Booking> getAllBookings = crit.list();
	commit();
	close();
	return getAllBookings;

	
	

}

public List<Booking> getByCity(String bcity){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class,"book")
			.createAlias("book.car", "car")
			.add(Restrictions.eq("car.city", bcity))
			.add(Restrictions.eq("car.status", "active"))
			.add(Restrictions.eq("Status", "active"));
	
	
	List<Booking> getBookings = crit.list();
	commit();
	close();
	return getBookings;
	
}

public List<Booking> getByState(String bstate){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class,"book")
			.createAlias("book.car", "car")
			.add(Restrictions.eq("car.status", "active"))
			.add(Restrictions.eq("car.state", bstate))
			.add(Restrictions.eq("Status", "active"));
	
	
	List<Booking> getBookings = crit.list();
	commit();
	close();
	return getBookings;
	
}
public List<Booking> getByType(String type){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class,"book")
			.createAlias("book.car", "car")
			.add(Restrictions.eq("car.type", type))
			.add(Restrictions.eq("car.status", "active"))
			.add(Restrictions.eq("Status", "active"));
	
	
	List<Booking> getBookings = crit.list();
	commit();
	close();
	return getBookings;
	
}




public List<Booking> getByCustomer(int id, String name){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class,"book")
			.createAlias("book.customer", "cust")
			.createAlias("book.car", "car")
			.add(Restrictions.eq("cust.Cid", id))
			.add(Restrictions.eq("cust.Cfname", name))
			.add(Restrictions.eq("car.status", "active"))
			.add(Restrictions.eq("Status", "active"));
	
	
	List<Booking> getBookings = crit.list();
	commit();
	close();
	return getBookings;
	
}








public Booking getByBookingId(int id){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class);
	crit.add(Restrictions.eq("bookingId", id));
	crit.add(Restrictions.eq("Status", "active"));
	Booking getbyid = (Booking)crit.uniqueResult();
	commit();
	close();
	return getbyid;

}
	
public boolean updateBooking(int id, Date startdate, Date enddate, int amount) {
	
try {
		begin();
		Criteria crit = getSession().createCriteria(Booking.class);
		crit.add(Restrictions.eq("bookingId", id));
		Booking book = (Booking)crit.uniqueResult();
		
		book.setStartDate(startdate);
		book.setEndDate(enddate);
		book.setBookingAmount(amount);
		
		getSession().save(book);
		commit();
		
		return true;
		}
	catch(HibernateException e) {
		e.printStackTrace();
		rollback();
		return false;
		
	}
	finally {
	close();

	}
	
	
}







public void DeleteBooking (int id)
{
	try {
	begin();
	Criteria crit = getSession().createCriteria(Booking.class);
	crit.add(Restrictions.eq("bookingId", id));
	Booking b = (Booking) crit.uniqueResult();
	b.setStatus("inactive");
	getSession().save(b);
	commit();
	
	
	}
	catch(HibernateException e) {
		e.printStackTrace();
		rollback();
		
		
	}
	finally {
	close();

	}
	
}

public List<Booking> getbyDate(Date startdate, Date enddate){
	
	try {
	begin();
	Criteria crit = getSession().createCriteria(Booking.class);
	crit.add(Restrictions.ge("StartDate", startdate));
	//crit.add(Restrictions.le("enddate", startdate));
	//crit.add(Restrictions.ge("startdate", enddate));
	crit.add(Restrictions.le("EndDate", enddate));
	crit.add(Restrictions.eq("Status", "active"));
	
	List<Booking> getbydate = crit.list();
	
	commit(); 
	return getbydate;
	}
	catch(HibernateException e) {
		e.printStackTrace();
		rollback();
		return null;
		
	}
	finally {
		close();
	}
	
	
	
	
}





public List<Booking> getDeletedBookings(){
	
	begin();
	Criteria crit = getSession().createCriteria(Booking.class,"book")
			.add(Restrictions.eq("Status", "inactive"));
	
	
	List<Booking> getBookings = crit.list();
	commit();
	close();
	return getBookings;
	
}


	
}
