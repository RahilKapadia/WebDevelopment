/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.mainpackage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.Dao.AdminDao;
import com.me.Dao.CarDao;
import com.me.Dao.CustomerDao;
import com.me.Dao.OwnerDao;
import com.me.pojo.Car;
import com.me.pojo.Customer;
import com.me.pojo.Owner;


@Controller
public class LoginController {
	
	

	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String handleRequest(HttpServletRequest request, CustomerDao custdao,HttpSession session,OwnerDao owndao,AdminDao admindao,CarDao cardao) {
		
		String newoption = request.getParameter("newoption");
		if(newoption == null)
			return"Login";
		if(newoption.equals("newcustomer")) {
			return "customer_new";
			
		}
		if(newoption.equals("newowner")) {
			return "Owner_new";
			
		}
		
		if(newoption.equals("logout")) {
			
			session.invalidate();
			return "Login";
			
		}
		
	if(newoption.equals("pass")) {
			
			return "Forgotpass";
			
		}
		
	if(newoption.equals("forgot")) {
		
		String fusername = request.getParameter("fusername");
		String email = request.getParameter("email");
		String role =request.getParameter("roles");
		if(role == null)
			return "error";
		if(role.equals("Customer")) {
			Customer cust = custdao.getbyuser(fusername, email);
			if(cust == null)
				return "error";
			else {
				String upass= cust.getPassword();
				
				Email uemail = new SimpleEmail();
				
				uemail.setHostName("smtp.mail.yahoo.com");
				
				uemail.setSmtpPort(465);

				uemail.setAuthenticator(new DefaultAuthenticator("rahil.kapadia@yahoo.com", "jvmgvcpzubqzjelt"));
			
				uemail.setSSLOnConnect(true);    
			
				try {
					uemail.setFrom("rahil.kapadia@yahoo.com");
				
					uemail.setSubject("Account password");
					
					uemail.setMsg(upass);
				
					uemail.addTo(email);
				
					uemail.send();
					
					return "sentemail";
					
				} catch (EmailException e) {
					System.out.println("email exception:"+ e);
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "error";
				}
				
					
				
			}
			
			
	
				
			}
			
		if(role.equals("Car Owner")) {	
			
			
			Owner own = owndao.getbyuser(fusername, email);
			if(own == null)
				return "error";
			else {
				String upass= own.getPassword();
				
				Email uemail = new SimpleEmail();
				
				uemail.setHostName("smtp.mail.yahoo.com");
				
				uemail.setSmtpPort(465);

				uemail.setAuthenticator(new DefaultAuthenticator("rahil.kapadia@yahoo.com", "jvmgvcpzubqzjelt"));
			
				uemail.setSSLOnConnect(true);    
			
				try {
					uemail.setFrom("rahil.kapadia@yahoo.com");
				
					uemail.setSubject("Account password");
					
					uemail.setMsg(upass);
				
					uemail.addTo(email);
				
					uemail.send();
					
					return "sentemail";
					
				} catch (EmailException e) {
					System.out.println("email exception:"+ e);
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "error";
				}
				
					
				
			}
			
			
			
			
		}
		
		
		
		

		
	}
		
	
	                    
		
		
		
		String username=(String) request.getAttribute("username");
		
		
		if(username == null) {
			return "Login";
		}
		
		else {
		
		String password = (String)request.getAttribute("password");
		String roles=(String) request.getAttribute("role");
		
		List<Car> getcity =  cardao.getCity();
		session.setAttribute("allCity",getcity);
		
		if(roles == null) {
			return"Login";
		}
		if(roles.equals("Customer")) {
			
			
			
			
			Customer c1 = custdao.getCustomer(username, password);
			session.setAttribute("customer", c1);
			
			
				if(c1 == null)
				{
				 return "error";
					}
				
				else 
				{
					
					System.out.println(getcity);
					return "customer_home";
				}
				
			}
		
		if (roles.equals("Car Owner")) {
			
			Owner o1 = owndao.getOwner(username,password);
			
			
				if(o1 == null) 
				{
				 return "error";
				}
				
				else 
				{
					session.setAttribute("owner", o1);
					return "Owner_home";
					
				}		
			
		}
		
		if(roles.equals("Admin")) {
			
			boolean b = admindao.checkCred(username, password);
			
			if(b)
				return "admin_home";
			else
				return "error";
			
		}
			
			
//			if(username.equals("Admin") && password.equals("Sysadmin1")) {
//				
//				return "admin_home";
//			}
//		
//			else
//				return "error";
//		
//		}
		
		
		
		
	
		
	}
		 	
		
		return "s";
		
		
	}		
}
//    protected ModelAndView handleRequestInternal(
//            HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//       
//    
//  HttpSession session = request.getSession();
//   if(session.getAttribute("USER") == null ){
//          return new ModelAndView("Login");
//    }
//   ModelAndView mv = null;
//   String username = request.getParameter("username");
//   String password = request.getParameter("password");
//   String role= request.getParameter("role");
//   
//   
//   
// return mv;
// 
//}
//}
