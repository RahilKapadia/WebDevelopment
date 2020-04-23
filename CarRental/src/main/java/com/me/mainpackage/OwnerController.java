package com.me.mainpackage;

import org.springframework.stereotype.Controller;


	
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;


import com.me.Dao.OwnerDao;
import com.me.pojo.Customer;
import com.me.pojo.Owner;
	
@Controller
public class OwnerController {
	
	@RequestMapping(value = "/owner", method = RequestMethod.POST)
	public String handleRequest(HttpServletRequest request, OwnerDao owndao, HttpSession session) throws ParseException {
		
		String purpose = request.getParameter("purpose");
        if(purpose == null)
     	   return "home";
        
        if(purpose.equals("gotoupdate")) {
      	  return "owner_update";
        }
		
        if(purpose.equals("gotoaddcar")) {
        	  return "addCar";
          }
		
          
          
          if(purpose.equals("addowner")) {
        	  String username = request.getParameter("username");
      		String password = request.getParameter("password");
      		String fname = request.getParameter("ofname");
      		String lname = request.getParameter("olname");
      		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                Date dob = formatter.parse(request.getParameter("odob"));
                String gender = request.getParameter("ogender");
                String street = request.getParameter("ostreet");
                String city = request.getParameter("ocity");
                String state= request.getParameter("ostate");
                String zip = request.getParameter("ozip");
                String contact = request.getParameter("ocontact");
                String email = request.getParameter("oemail");
                String license = request.getParameter("olicense");
       	   boolean insert = owndao.addOwner(username,password,fname,lname,dob,gender,street,city,state,zip,contact,email,license);
       	   if(insert)
       		   return "ownreg_confirm";
       	   else
       		   return"error";
          
          }
          
          if(purpose.equals("updatecustomer")) {
  			
  			int id = Integer.parseInt(request.getParameter("oid"));
  			String username = request.getParameter("username");
  			String password = request.getParameter("password");
  			String fname = request.getParameter("ofname");
  			String lname = request.getParameter("olname");
  			  SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
  	          Date dob = formatter.parse(request.getParameter("odob"));
  	          String gender = request.getParameter("ogender");
  	          String street = request.getParameter("ostreet");
  	          String city = request.getParameter("ocity");
  	          String state= request.getParameter("ostate");
  	          String zip = request.getParameter("ozip");
  	          String contact = request.getParameter("ocontact");
  	          String email = request.getParameter("oemail");
  	          String license = request.getParameter("olicense");
      	   
      	  Owner o = owndao.updateOwner(id,username,password,fname,lname,dob,gender,street,city,state,zip,contact,email,license);
      	   if(o == null) 
      		   return"error";
      	   
      	   else {
      		   session.setAttribute("owner", o);
      		   return "Owner_home";
      		   
      	   } 
         }
          if(purpose.equals("allOwner")) {
        	  
        	  
        	  List<Owner> olist = owndao.getOwners();
        	  request.setAttribute("ownerList",olist);
        	  
        	  return "ViewOwners";
        	  
          }
          if(purpose.equals("delete")) {
        	  
        	  int oid = Integer.parseInt(request.getParameter("id"));
        	  boolean d = owndao.deleteOwner(oid);
        	  if(d) {
        		  List<Owner> olist = owndao.getOwners();
            	  request.setAttribute("ownerList",olist);
            	  
            	  return "ViewOwners";}
        	  else
        		  return "error";
        	  
          }
          
          
          
          return "home";
          
}
}