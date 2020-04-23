package com.me.mainpackage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.Dao.BookingDao;
import com.me.Dao.CarDao;
import com.me.pojo.Booking;
import com.me.pojo.Car;
import com.me.pojo.Customer;
import com.me.pojo.Owner;





@Controller
public class BookingController {
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String handleRequest(HttpServletRequest request, HttpSession session, CarDao cardao, BookingDao bookdao) throws ParseException {
		
		String purpose = request.getParameter("purpose");
		if(purpose == null)
			return "Login";
		
		if(purpose.equals("gotoBook")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			Car onecar = cardao.getCarbyId(id);
			
			session.setAttribute("carforbook", onecar);
			
			return"BookCar";
			
			
			
		}
		if(purpose.equals("bookcar")) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date startdate = formatter.parse(request.getParameter("startdate"));
            Date enddate = formatter.parse(request.getParameter("enddate"));
            
            
          
 	       long difference = enddate.getTime() - startdate.getTime();
 	     float days = (difference / (1000*60*60*24));
            
         
			
			Customer currentcustomer = (Customer)session.getAttribute("customer");
			String cemail = currentcustomer.getCemail();
			
			Car currentcar =(Car) session.getAttribute("carforbook");
			int price = currentcar.getPriceperday();
			
			int oid = currentcar.getOwner().getOid();
			 int totprice = 1;
			if((int)days == 0) {
				
				totprice = price;
			}
			else
			{
		     totprice = (int)days* price;
			}
		     
			Calendar c = Calendar.getInstance();
			c.setTime(enddate);
			c.add(Calendar.DAY_OF_MONTH, 1);  
			String newdate = formatter.format(c.getTime());
		    Date newavaildate = formatter.parse(newdate);
		    
		    int carid = currentcar.getCarid();
		    Date sparedate = currentcar.getAvailto();
		    cardao.updateAvailDate(carid, newavaildate);
		    session.setAttribute("spare", sparedate);
		    
		    
			
			
			boolean confirm = bookdao.addBooking(currentcar, currentcustomer, oid, startdate, enddate, totprice);
			
			if(confirm) {
				
				request.setAttribute("amount", totprice);
				request.setAttribute("toemail", cemail);
				
				return"Booking_confirm";
			}
			else
				return "transerror";
		}
		
		if(purpose.equals("viewbyowner")) {
			
			int oid = Integer.parseInt(request.getParameter("ownerid"));
			
			List<Booking> ownerbooking = bookdao.getByOwner(oid);
			
			if(ownerbooking.isEmpty())
				return "SearchEmpty";
			else {
			session.setAttribute("getByOwner", ownerbooking);
		
			return"BookingbyOwner";
			}
		}
		if(purpose.equals("viewcustbooking")) {
			
			Customer cust = (Customer)session.getAttribute("customer");
			
			List<Booking> getbyCustomer = bookdao.getByCustomer(cust);
			
			if(getbyCustomer.isEmpty())
				return "SearchEmpty";
			
			else {
				request.setAttribute("getByCustomer",getbyCustomer);
				return "BookingByCustomer";
			
		}

		}
		
		if (purpose.equals("allBookings")) {
			
			List<Booking> getAllBookings = bookdao.getBookings();
			if(getAllBookings.isEmpty())
				return "SearchEmpty";
			else {
				request.setAttribute("getBookings",getAllBookings);
				return "ViewAllBookings";
			}
		}
			
		
		if(purpose.equals("gotoUpdate")) {
			
		
			int id = Integer.parseInt(request.getParameter("bookingid"));
			Booking book = bookdao.getByBookingId(id);
			request.setAttribute("book", book);
			return "Booking_update";
			
		
			
		}
		
		if(purpose.equals("updateBooking")) {
			
			
			
			int id = Integer.parseInt(request.getParameter("bookId"));
			Booking cbook = bookdao.getByBookingId(id);
			int price = cbook.getCar().getPriceperday();
			int carid = cbook.getCar().getCarid();
			String cemail = cbook.getCustomer().getCemail();
			
			
			
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date startdate = formatter.parse(request.getParameter("startdate"));
            Date enddate = formatter.parse(request.getParameter("enddate"));
            
            Calendar c = Calendar.getInstance();
			c.setTime(enddate);
			c.add(Calendar.DAY_OF_MONTH, 1);  
			String newdate = formatter.format(c.getTime());
		    Date newavaildate = formatter.parse(newdate);
		    cardao.updateAvailDate(carid, newavaildate);

            
            long difference = enddate.getTime() - startdate.getTime();
	 	     float days = (difference / (1000*60*60*24));
	 	    int totprice = (int)days* price;
	 	     
                     
            
			Boolean b= bookdao.updateBooking(id, startdate, enddate,totprice);
			if(b) {
				List<Booking> getAllBookings = bookdao.getBookings();
				if(getAllBookings.isEmpty())
					return "SearchEmpty";
				else {
					request.setAttribute("getBookings",getAllBookings);
					

					Email uemail = new SimpleEmail();
					
					uemail.setHostName("smtp.mail.yahoo.com");
					
					uemail.setSmtpPort(465);

					uemail.setAuthenticator(new DefaultAuthenticator("rahil.kapadia@yahoo.com", "jvmgvcpzubqzjelt"));
				
					uemail.setSSLOnConnect(true);    
				
					try {
						uemail.setFrom("rahil.kapadia@yahoo.com");
					
						uemail.setSubject("Booking modification");
						
						uemail.setMsg("Your car booking has been updated. Login to check details! ");
					
						uemail.addTo(cemail);
					
						uemail.send();
						
						return "ViewAllBookings";
						
					} catch (EmailException e) {
						System.out.println("email exception:"+ e);
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
					
			
					
				}
				
				
				
				
				
			}
			else
				return "home";
	
			
		}
			
			
		if(purpose.equals("delete")) {
			
			int id = Integer.parseInt(request.getParameter("bookingid"));
			Booking book = bookdao.getByBookingId(id);
			String owneremail = book.getCar().getOwner().getOemail();
			
			String custemail = book.getCustomer().getCemail();
		

			
			
			
			
			bookdao.DeleteBooking(id);
		//owner email
		
			Email email = new SimpleEmail();
			
			email.setHostName("smtp.mail.yahoo.com");
			
			email.setSmtpPort(465);

			email.setAuthenticator(new DefaultAuthenticator("rahil.kapadia@yahoo.com", "jvmgvcpzubqzjelt"));
		
			email.setSSLOnConnect(true);    
		
			try {
				email.setFrom("rahil.kapadia@yahoo.com");
			
				email.setSubject("Booking confirmation Mail");
				
				email.setMsg("Your car booking has been deleted. Login to check details");
			
				email.addTo(owneremail);
			
				email.send();
				
				
			} catch (EmailException e) {
				System.out.println("email exception:"+ e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(owneremail);
		// customer email
			
			Email cemail = new SimpleEmail();
			
			cemail.setHostName("smtp.mail.yahoo.com");
			
			cemail.setSmtpPort(465);

			cemail.setAuthenticator(new DefaultAuthenticator("rahil.kapadia@yahoo.com", "jvmgvcpzubqzjelt"));
		
			cemail.setSSLOnConnect(true);    
		
			try {
				cemail.setFrom("rahil.kapadia@yahoo.com");
			
				cemail.setSubject("Booking confirmation Mail");
				
				cemail.setMsg("Your car booking has been deleted. Login to check details");
			
				cemail.addTo(custemail);
			
				cemail.send();
				
				
			} catch (EmailException e) {
				System.out.println("email exception:"+ e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(custemail);
			
			
			
			//bookdao.DeleteBooking(id);
			
			List<Booking> getAllBookings = bookdao.getBookings();
			request.setAttribute("getBookings",getAllBookings);
			return "ViewAllBookings";
			
			
		}
			
		if(purpose.equals("bookingbyfilter")) {
			 return"Bookingbyfilter";
		}
		
		
		
		if(purpose.equals("bookingbycity")) {
			
			
			String bcity = request.getParameter("city");
			List<Booking> getBookings = bookdao.getByCity(bcity);
			if(getBookings.isEmpty())
				return "SearchEmpty";
			else {
				request.setAttribute("getBookings",getBookings);
				return "ViewAllBookings";
			}
			
			
			
		}
	if(purpose.equals("bookingbystate")) {
			
			
			String bstate = request.getParameter("state");
			List<Booking> getBookings = bookdao.getByState(bstate);
			if(getBookings.isEmpty())
				return "SearchEmpty";
			else {
				request.setAttribute("getBookings",getBookings);
				return "ViewAllBookings";
			}
			
			
			
		}
	if(purpose.equals("bookingbycustomer")) {
		
		int id = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("cname");
		List<Booking> getBookings = bookdao.getByCustomer(id,name);
		if(getBookings.isEmpty())
			return "SearchEmpty";
		else {
			request.setAttribute("getBookings",getBookings);
			return "ViewAllBookings";
		}
		
		
		
	}
	
	if(purpose.equals("bookingbytype")) {
		
		
		String type = request.getParameter("type");
		List<Booking> getBookings = bookdao.getByType(type);
		if(getBookings.isEmpty())
			return "SearchEmpty";
		else {
			request.setAttribute("getBookings",getBookings);
			return "ViewAllBookings";
		}
		
		
		
	}
if(purpose.equals("bookingbydate")) {
		
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    Date startdate = formatter.parse(request.getParameter("startdate"));
    Date enddate = formatter.parse(request.getParameter("enddate"));
	
		List<Booking> getByDate = bookdao.getbyDate(startdate, enddate);
		if(getByDate.isEmpty())
			return "SearchEmpty";
		else {
			request.setAttribute("getBookings",getByDate);
			return "ViewAllBookings";
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
if(purpose.equals("bookingdeleted")) {
		
		
	
		List<Booking> getBookings = bookdao.getDeletedBookings();
		if(getBookings.isEmpty())
			return "SearchEmpty";
		else {
			request.setAttribute("getBookings",getBookings);
			return "ViewDeletedBookings";
		}
		
		
		
	}
		
		
		
		return "s";
	}
	
	
	

}
