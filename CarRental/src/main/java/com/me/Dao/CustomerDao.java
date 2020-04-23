package com.me.Dao;

import java.util.List;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.me.pojo.Customer;

public class CustomerDao extends DAO {
	
	Session session = getSession();
	public Customer getCustomer(String uname, String upass) {
		
		
		@SuppressWarnings("deprecation")
		Criteria crit = getSession().createCriteria(Customer.class);
		crit.add(Restrictions.eq("username",uname));
		crit.add(Restrictions.eq("password",upass));
		
		Customer c = (Customer) crit.uniqueResult();
		
		
		return(c);
	}

	public boolean addCustomer(String username,String  password,String fname,String lname,Date dob,String gender,String street,String city,String state,String zip,String contact,String email,String license) {
		
		try {
		
		Customer cust = new Customer();
		cust.setUsername(username);
		cust.setPassword(password);
		cust.setCfname(fname);
		cust.setClname(lname);
		cust.setCdob(dob);
		cust.setCgender(gender);
		cust.setCstreet(street);
		cust.setCcity(city);
		cust.setCstate(state);
		cust.setCzip(zip);
		cust.setCcontact(contact);
		cust.setCemail(email);
		cust.setClicense(license);
		begin();
		getSession().save(cust);
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
public Customer updateCustomer(int cid,String username,String  password,String fname,String lname,Date dob,String gender,String street,String city,String state,String zip,String contact,String email,String license) {
		
		try {
		
			
	
		begin();
        Query q = getSession().createQuery("from Customer where Cid= :id");
        q.setLong("id", cid);
		
		Customer cust = (Customer)q.uniqueResult();
		cust.setUsername(username);
		cust.setPassword(password);
		cust.setCfname(fname);
		cust.setClname(lname);
		cust.setCdob(dob);
		cust.setCgender(gender);
		cust.setCstreet(street);
		cust.setCcity(city);
		cust.setCstate(state);
		cust.setCzip(zip);
		cust.setCcontact(contact);
		cust.setCemail(email);
		cust.setClicense(license);
		getSession().save(cust);
		commit();
		return cust;
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

public Customer getbyuser(String username, String email) {
	
	try {
	begin();
	Criteria crit = getSession().createCriteria(Customer.class);
	crit.add(Restrictions.eq("username",username));
	crit.add(Restrictions.eq("cemail",email));
	
	Customer custom = (Customer) crit.uniqueResult();
	commit();
	return custom;
	
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







public List<Customer> getCustomers(){
	begin();
	@SuppressWarnings("deprecation")
	Criteria crit = getSession().createCriteria(Customer.class);
	List<Customer> clist = crit.list();
	commit();
	close();
	return clist;
	
}

public boolean deleteCust(int cid) {
	
    try {
        begin();
        Query q = getSession().createQuery("from Customer where cid= :id");
        q.setLong("id", cid);
        Customer cdel = (Customer) q.uniqueResult();
        getSession().delete(cdel);
        commit();
        return true;
    } catch (HibernateException e) {
        e.printStackTrace();
        rollback();
        return false;
    } finally {
        close();
    }
}
	
}