package com.me.Dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.me.pojo.Admin;

public class AdminDao extends DAO {
	
public boolean checkCred(String uname, String upass) {
		
		begin();
		@SuppressWarnings("deprecation")
		Criteria crit = getSession().createCriteria(Admin.class);
		crit.add(Restrictions.eq("username",uname));
		crit.add(Restrictions.eq("pass",upass));
		
		Admin admin = (Admin)crit.uniqueResult();
		commit();
		close();
		if(admin == null) {
			return false;
		}
		else
			return true;
	}

}
