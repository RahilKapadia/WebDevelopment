package com.me.mainpackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.me.Dao.CustomerDao;
import com.me.pojo.Customer;

@Controller
public class CustomerController {
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String handleRequest(HttpServletRequest request, CustomerDao custdao, HttpSession session, @Valid @ModelAttribute("customer") Customer customer, BindingResult result, ModelMap model, SessionStatus status)throws ParseException {
		
	      String purpose = request.getParameter("purpose");
		if(purpose == null)
	    	   return "home";
		  if(purpose.equals("gotoupdate")) {
	    	 
			 System.out.println(session.getAttribute("customer"));
			 
	    	   return "customer_update";
	       }
		
	
       
      
       if(purpose.equals("addcustomer")) {
    	   
    	   
   
    	   
    	   
    	   
    		String username = request.getParameter("username");
    		String password = request.getParameter("password");
    		String fname = request.getParameter("cfname");
    		String lname = request.getParameter("clname");
    		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
              Date dob = formatter.parse(request.getParameter("cdob"));
              String gender = request.getParameter("cgender");
              String street = request.getParameter("cstreet");
              String city = request.getParameter("ccity");
              String state= request.getParameter("cstate");
              String zip = request.getParameter("czip");
              String contact = request.getParameter("ccontact");
              String email = request.getParameter("cemail");
              String license = request.getParameter("clicense");
             
              
    	   
    	   boolean insert = custdao.addCustomer(username,password,fname,lname,dob,gender,street,city,state,zip,contact,email,license);
    	   if(insert)
    		   return "custreg_confirm";
    	   else
    		   return"error";
    	   }
    	   
    	   
       
       
       
if(purpose.equals("updatecustomer")) {
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String fname = request.getParameter("cfname");
	String lname = request.getParameter("clname");
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
      Date dob = formatter.parse(request.getParameter("cdob"));
      String gender = request.getParameter("cgender");
      String street = request.getParameter("cstreet");
      String city = request.getParameter("ccity");
      String state= request.getParameter("cstate");
      String zip = request.getParameter("czip");
      String contact = request.getParameter("ccontact");
      String email = request.getParameter("cemail");
      String license = request.getParameter("clicense");
      
      		
			int id = Integer.parseInt(request.getParameter("cid"));
    	  Customer c = custdao.updateCustomer(id,username,password,fname,lname,dob,gender,street,city,state,zip,contact,email,license);
    	   if(c == null) 
    		   return"error";
    	   
    	   else {
    		   session.setAttribute("customer", c);
    		   return "customer_home";
    		   
    	   } 
       }
  if(purpose.equals("allCustomer")) {
	  
	  
	  List<Customer> clist = custdao.getCustomers();
	  request.setAttribute("custList",clist);
	  
	  return "ViewCustomers";
	  
  }
  
  if(purpose.equals("delete")) {
	  
	  int cid = Integer.parseInt(request.getParameter("id"));
	  boolean d = custdao.deleteCust(cid);
	  if(d) {
		  List<Customer> clist = custdao.getCustomers();
		  request.setAttribute("custList",clist);
		  return "ViewCustomers";
	  }
	  else
		  return "error";
	  
  }
  
  
  
       
     
        
  return "home";
          
          
          
		
	}
		

}
