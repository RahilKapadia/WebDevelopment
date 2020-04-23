package com.me.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RentalInterceptor implements HandlerInterceptor {
	
	@Autowired
	private HttpSession session;

	private static final Logger logger = LoggerFactory.getLogger(RentalInterceptor.class);
	
	public String sanitize(String value) {
		System.out.println("Before : " + value);
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]javascript:(.)[\\\"\\\']", "\"\"");
        value = value.replaceAll("<script.*?>", "");
        value = value.replaceAll("</script.*?>", "");
        value = value.replaceAll("</sql.*?>", "");
        value = value.replaceAll("<sql.*?>", "");
        value = value.replaceAll("\\*", "_");
        value = value.replaceAll("=", "_");
        value = value.replaceAll("\\?", "_");
        value = value.replaceAll(",", "_");
        value = value.replaceAll("<script>", "");
        value = value.replaceAll("</script>", "");
        value = value.replaceAll("==", "_");
        value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
        value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
        value = value.replaceAll("'", "& #39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        
        System.out.println("After" + value);
        return value;
    }
	
	
	
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Inside pre handle");
		System.out.println("sanitizing interceptor");
		
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
        	request.setAttribute("executionTime", startTime);
        	
        
        	String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
//		int bookingid = Integer.parseInt(request.getParameter("bookingid"));
//		int bookId = Integer.parseInt(request.getParameter("bookId"));
//		int ownerid = Integer.parseInt(request.getParameter("ownerid"));
//		int cid

		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		

        if (username != null) {
            request.setAttribute("username", sanitize(username));
        }
        if (password != null) {
            request.setAttribute("password", sanitize(password));
        }
        if (role != null) {
            request.setAttribute("role", sanitize(role));
        }
        
        
       
        
        if (street != null) {
            request.setAttribute("street", sanitize(street));
        }
        if (city != null) {
            request.setAttribute("city", sanitize(city));
        }
        if (zipcode != null) {
            request.setAttribute("zipcode", sanitize(zipcode));
        }
        if (state != null) {
            request.setAttribute("state", sanitize(state));
        }
      
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Inside post handle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Inside after completion");
	}
}