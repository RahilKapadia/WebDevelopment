package com.me.mainpackage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.Dao.CarDao;
import com.me.pojo.Car;
import com.me.pojo.Owner;

@Controller
public class CarController {
	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public String handleRequest(HttpServletRequest request, HttpSession session, CarDao cardao) throws ParseException {
		
		String purpose = request.getParameter("purpose");
		if(purpose ==  null) {
			return"Login";
		}
		if(purpose.equals("addCar"))
		{
			Owner own = (Owner)session.getAttribute("owner");
			String model = request.getParameter("model");
			String make = request.getParameter("make");
			String type = request.getParameter("type");
			String color = request.getParameter("color");
			int seats = Integer.parseInt(request.getParameter("seats"));
			int myear = Integer.parseInt(request.getParameter("myear"));
			
			int miles = Integer.parseInt(request.getParameter("miles"));
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String vin = request.getParameter("vin");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date availfrom = formatter.parse(request.getParameter("availfrom"));
            Date availto = formatter.parse(request.getParameter("availto"));
        	int priceperday = Integer.parseInt(request.getParameter("priceperday"));
          boolean c =   cardao.addCar(model,make, type,color,seats,myear, miles, city, state, vin ,availfrom, availto,priceperday,own);
            if(c) {
            	return "Owner_home";
            }
            else
            	return "transerror";
            
            
            
		}
		if(purpose.equals("searchcar")) {
			
			String scity = request.getParameter("city");
			String stype = request.getParameter("type");
			int sseats = Integer.parseInt(request.getParameter("seats"));
			SimpleDateFormat formatters = new SimpleDateFormat("yyyy/MM/dd");
			Date savailfrom = formatters.parse(request.getParameter("availfrom"));
			
			List<Car> searchcars = cardao.searchcar(scity,stype, savailfrom, sseats);
			if(searchcars.isEmpty())
				return "SearchEmpty";
				else {
			session.setAttribute("searchlist", searchcars);
			return"SearchCars";
		}	
		}
		
		if(purpose.equals("searchbycity")) {
			
			String sbcity = request.getParameter("sbcity");
			
			List<Car> searchbycity = cardao.searchByCity(sbcity);
		
			if(searchbycity.isEmpty())
				return "SearchEmpty";
				else {
			request.setAttribute("searchcity", searchbycity);
			return"homeSearch";
		}
			
			
		}
		
		if(purpose.equals("viewownercars")) {
			
			Owner own = (Owner)session.getAttribute("owner");
			List <Car> ownercars = cardao.getCarbyOwnerId(own);
			if(ownercars.isEmpty())
				return "SearchEmpty";
			
			else {
				session.setAttribute("ownercars",ownercars);
				return "ViewOwnerCars";
			
			
		}
		}
		if(purpose.equals("modify")) {
			
				int id = Integer.parseInt(request.getParameter("id"));
				Car mcar = cardao.getCarbyId(id);
				request.setAttribute("mcar", mcar);
				return"ModifyCar";
			
			
		}
		if(purpose.equals("updateCar"))
		{
			Owner own = (Owner)session.getAttribute("owner");
			String model = request.getParameter("model");
			String make = request.getParameter("make");
			String type = request.getParameter("type");
			String color = request.getParameter("color");
			int seats = Integer.parseInt(request.getParameter("seats"));
			int myear = Integer.parseInt(request.getParameter("myear"));
			
			int miles = Integer.parseInt(request.getParameter("miles"));
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String vin = request.getParameter("vin");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date availfrom = formatter.parse(request.getParameter("availfrom"));
            Date availto = formatter.parse(request.getParameter("availto"));
        	int priceperday = Integer.parseInt(request.getParameter("priceperday"));
        	int id = Integer.parseInt(request.getParameter("id"));
          boolean c =   cardao.updateCar(id,model,make, type,color,seats,myear, miles, city, state, vin ,availfrom, availto,priceperday,own);
            if(c) {
            	return "Owner_home";
            }
		}
		
		if (purpose.equals("allCars")){
			
			List<Car> allCars = cardao.getCars();
			if(allCars.isEmpty())
				return "SearchEmpty";
			else {
				request.setAttribute("allCars", allCars);
				return "ViewAllCars";
				}

		}
		
		if(purpose.equals("carbyfilter")) {
			
			
			return"Carbyfilter";
			
			
			
			
		}
		if(purpose.equals("carsbycity")) {
			
			String scity = request.getParameter("city");
			
			List<Car> getByCity = cardao.getByCity(scity);
			
			if(getByCity.isEmpty())
				return "SearchEmpty";
			else {
				request.setAttribute("filtercars",getByCity);
				return "FilterCars";
			}
	
			
		}
if(purpose.equals("carsbystate")) {
			
			String sstate = request.getParameter("state");
			
			List<Car> getByState = cardao.getByState(sstate);
			
			if(getByState.isEmpty())
				return "SearchEmpty";
			else {
				request.setAttribute("filtercars",getByState);
				return "FilterCars";
			}
	
			
		}
if(purpose.equals("carbytype")) {
	
	String type = request.getParameter("type");
	
	List<Car> getByType = cardao.getByType(type);
	
	if(getByType.isEmpty())
		return "SearchEmpty";
	else {
		request.setAttribute("filtercars",getByType);
		return "FilterCars";
	}

	
}





if(purpose.equals("carbyowner")) {
	
	int oid = Integer.parseInt(request.getParameter("oid"));
	String oname = request.getParameter("oname");
	
	List<Car> getByOwner = cardao.getByOwner(oid, oname);
	
	if(getByOwner.isEmpty())
		return "SearchEmpty";
	else {
		request.setAttribute("filtercars",getByOwner);
		return "FilterCars";
	}

	
}
	
		
		
		
		
		
		
		if(purpose.equals("delete")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			cardao.DeleteCar(id);
			List<Car> allCars = cardao.getCars();
			if(allCars.isEmpty())
				return "SearchEmpty";
			else {
				request.setAttribute("allCars", allCars);
				return "ViewAllCars";
				}
			
			
		}
		

		return"home";
}
}