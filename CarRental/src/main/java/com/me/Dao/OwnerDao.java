package com.me.Dao;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.me.pojo.Customer;
import com.me.pojo.Owner;


public class OwnerDao extends DAO {
	
	Session session = getSession();
	public Owner getOwner(String uname, String upass) {
		
		
		@SuppressWarnings("deprecation")
		Criteria crit = getSession().createCriteria(Owner.class);
		crit.add(Restrictions.eq("username",uname));
		crit.add(Restrictions.eq("password",upass));
		
		Owner on = (Owner)crit.uniqueResult();
		
		
		return(on);
	}
	
	
public boolean addOwner(String username,String  password,String fname,String lname,Date dob,String gender,String street,String city,String state,String zip,String contact,String email,String license) {
		
		try {
		
		Owner own = new Owner();
		own.setUsername(username);
		own.setPassword(password);
		own.setOfname(fname);
		own.setOlname(lname);
		own.setOdob(dob);
		own.setOgender(gender);
		own.setOstreet(street);
		own.setOcity(city);
		own.setOstate(state);
		own.setOzip(zip);
		own.setOcontact(contact);
		own.setOemail(email);
		own.setOlicense(license);
		begin();
		getSession().save(own);
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

public Owner updateOwner(int oid,String username,String  password,String fname,String lname,Date dob,String gender,String street,String city,String state,String zip,String contact,String email,String license) {
	
	try {
	
	
	begin();
    Query q = getSession().createQuery("from Owner where Oid= :id");
    q.setLong("id", oid);
	
   Owner own = (Owner)q.uniqueResult();
	own.setUsername(username);
	own.setPassword(password);
	own.setOfname(fname);
	own.setOlname(lname);
	own.setOdob(dob);
	own.setOgender(gender);
	own.setOstreet(street);
	own.setOcity(city);
	own.setOstate(state);
	own.setOzip(zip);
	own.setOcontact(contact);
	own.setOemail(email);
	own.setOlicense(license);
	getSession().save(own);
	commit();
	return own;
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

public List<Owner> getOwners()
{
	begin();
    Query q = getSession().createQuery("from Owner");
    List<Owner> olist =  q.getResultList();
    commit();
    close();
    return olist;
}

public Owner getbyuser(String username, String email) {
	
	try {
	begin();
	Criteria crit = getSession().createCriteria(Owner.class);
	crit.add(Restrictions.eq("username",username));
	crit.add(Restrictions.eq("Oemail",email));
	
	Owner own = (Owner) crit.uniqueResult();
	commit();
	return own;
	
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










public boolean deleteOwner(int oid) {
	
    try {
        begin();
        Query q = getSession().createQuery("from Owner where oid= :id");
        q.setLong("id", oid);
        Owner odel = (Owner) q.uniqueResult();
        getSession().delete(odel);
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
