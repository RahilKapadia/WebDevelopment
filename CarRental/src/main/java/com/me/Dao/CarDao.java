package com.me.Dao;
import org.hibernate.HibernateException;
import java.util.List;
import java.util.Date;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.me.pojo.Booking;
import com.me.pojo.Car;
import com.me.pojo.Customer;
import com.me.pojo.Owner;
public class CarDao extends DAO {
	
	public boolean addCar(String model, String make, String type, String color, int seats, int myear, int miles, String city, String state, String vin , Date availfrom, Date availto,int priceperday, Owner own) {
		
		try {
			
			Car car = new Car();
			car.setModel(model);
			car.setMake(make);
			car.setType(type);
			car.setColor(color);
			car.setSeats(seats);
			car.setMyear(myear);
			car.setMiles(miles);
			car.setCity(city);
			car.setState(state);
			car.setVin(vin);
			car.setAvailfrom(availfrom);
			car.setAvailto(availto);
			car.setPriceperday(priceperday);
			car.setOwner(own);
			car.setStatus("active");
		      
			begin();
			getSession().save(car);
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
	
	public List<Car> searchcar(String city, String type, Date availfrom, int seats){
		begin();
		Criteria crit = getSession().createCriteria(Car.class);
		crit.add(Restrictions.eq("city", city));
		crit.add(Restrictions.eq("type", type));
		crit.add(Restrictions.le("availfrom", availfrom));
		crit.add(Restrictions.ge("availto", availfrom));
		crit.add(Restrictions.ge("seats", seats));
		crit.add(Restrictions.eq("status", "active"));
		List<Car> searchlist = crit.list();
		commit();
		close();
		return searchlist;

	}
	
	public List<Car> searchByCity (String sbcity){
		
		begin();
		Criteria crit = getSession().createCriteria(Car.class);
		crit.add(Restrictions.eq("city", sbcity));
		crit.add(Restrictions.eq("status", "active"));
		List<Car> searchcity =  crit.list();
		commit();
		close();
		return searchcity;
	}
	public Car getCarbyId (int id) {
		
		begin();
		Criteria crit = getSession().createCriteria(Car.class);
		crit.add(Restrictions.eq("carid", id));
		Car onecar = (Car) crit.uniqueResult();
		crit.add(Restrictions.eq("status", "active"));
		commit();
		close();
		
		return onecar;
		
	}
	
public List<Car> getCarbyOwnerId (Owner own) {
		
		begin();
		Criteria crit = getSession().createCriteria(Car.class);
		crit.add(Restrictions.eq("owner", own));
		crit.add(Restrictions.eq("status", "active"));
		List<Car> ownercars = crit.list();
		commit();
		close();
		
		return ownercars;
		
	}
public List<Car> getCars() {
	
	begin();
	Criteria crit = getSession().createCriteria(Car.class);
	crit.add(Restrictions.eq("status","active"));
	
	List<Car> allcars = crit.list();
	commit();
	close();
	
	return allcars;
	
}




	
public boolean updateCar(int id,String model, String make, String type, String color, int seats, int myear, int miles, String city, String state, String vin , Date availfrom, Date availto,int priceperday, Owner own) {
	
	try {
		begin();
		Criteria crit = getSession().createCriteria(Car.class);
		crit.add(Restrictions.eq("carid",id));
		Car car = (Car) crit.uniqueResult();
		
		
		
	
		car.setModel(model);
		car.setMake(make);
		car.setType(type);
		car.setColor(color);
		car.setSeats(seats);
		car.setMyear(myear);
		car.setMiles(miles);
		car.setCity(city);
		car.setState(state);
		car.setVin(vin);
		car.setAvailfrom(availfrom);
		car.setAvailto(availto);
		car.setPriceperday(priceperday);
		car.setOwner(own);
	      
	
		getSession().save(car);
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

public void updateAvailDate(int id, Date newdate) {
	try {
		begin();
		Criteria crit = getSession().createCriteria(Car.class);
		crit.add(Restrictions.eq("carid",id));
		Car car = (Car) crit.uniqueResult();
		
		car.setAvailfrom(newdate);
		getSession().save(car);
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

public List<Car> getByCity(String city){
	
	begin();
	Criteria crit = getSession().createCriteria(Car.class);
	crit.add(Restrictions.eq("city",city));
	crit.add(Restrictions.eq("status","active"));
	
	List<Car> filtercars = crit.list();
	commit();
	close();
	
	return filtercars;
	
}

public List<Car> getByState(String state){
	
	begin();
	Criteria crit = getSession().createCriteria(Car.class);
	crit.add(Restrictions.eq("state",state));
	crit.add(Restrictions.eq("status","active"));
	
	List<Car> filtercars = crit.list();
	commit();
	close();
	
	return filtercars;
	
}
public List<Car> getByType(String type){
	
	begin();
	Criteria crit = getSession().createCriteria(Car.class);
	crit.add(Restrictions.eq("type",type));
	crit.add(Restrictions.eq("status","active"));
	
	List<Car> filtercars = crit.list();
	commit();
	close();
	
	return filtercars;
	
}







public List<Car> getByOwner(int id, String name) {
	
	try {
	begin();
	
	Criteria crit =  getSession().createCriteria(Car.class,"car")
			.createAlias("car.owner", "own")
			.add(Restrictions.eq("own.Oid",id))
			.add(Restrictions.eq("own.Ofname",name));
	
	List<Car> getbyowner = (List<Car>) crit.list();
	
	commit();
	return getbyowner;
			
	
	}
	catch(HibernateException e) {
		e.printStackTrace();
		
		rollback();
		return null;
	}finally {
		close();

		}
}

public List<Car> getCity (){
	
	try {
		begin();
		
		Criteria crit =  getSession().createCriteria(Car.class,"car")
						.add(Restrictions.eq("status", "active"))
						.setProjection(Projections.distinct(Projections.property("car.city")));
                
				
		
		List<Car> getcity = crit.list();
		
		commit();
		return getcity;
				
		
		}
		catch(HibernateException e) {
			e.printStackTrace();
			
			rollback();
			return null;
		}finally {
			close();

			}
	
	
	
	
}





public void DeleteCar(int id) {
	
	try {
		begin();
		Criteria crit = getSession().createCriteria(Car.class);
		crit.add(Restrictions.eq("carid", id));
		Car car = (Car) crit.uniqueResult();
		car.setStatus("inactive");
	
		getSession().save(car);
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
	
	
	

}
