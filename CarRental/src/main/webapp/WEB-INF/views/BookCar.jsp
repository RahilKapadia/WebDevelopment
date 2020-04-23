<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import ="com.me.pojo.Car" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href= "<%= request.getContextPath() %>/resources/Styles.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <title>JSP Page</title>
     
     <script>
     function validatebook(){

            var d = /^([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))$/;

            var x= document.forms["bookform"]["availfrom"].value;
            var y = document.forms["bookform"]["availto"].value;
            var s = document.forms["bookform"]["startdate"].value;
            var e = document.forms["bookform"]["enddate"].value;
            var Availfrom = new Date(x);
            var Availto = new Date(y);
            var Startdate = new Date(s);
            var Enddate = new Date(e);

            if(!document.forms["bookform"]["startdate"].value.match(d)){

              alert('Startdate must be in yyyy/mm/dd format!');

              return false;

            }

            if(!document.forms["bookform"]["enddate"].value.match(d)){

              alert(' Enddate must be in yyyy/mm/dd format!');

              return false;
              
            }

            var Availfrom = new Date(x);
            var Availto = new Date(y);
            var Startdate = new Date(s);
            var Enddate = new Date(e);


      if(Availfrom > Startdate)
      {
                alert("Start date must be after available date");    
                
                 return false;
      }
 
      if(Startdate > Enddate)
      {
                alert("End date must be after start date");    
                
                 return false;
      }
      if(Enddate > Availto)
      {
          alert("End date must be before Available to date");

          return false;    

      }


        return true; 
     }
     </script>

    </head>
    <body class= "bodydesign">

        <%@ include file = "header.jsp" %>
         <% 
       Car cb = (Car)session.getAttribute("carforbook");
    %>
      <h1> Car Booking Form </h1>
      <form class="formstyle" action="/mainpackage/booking" name="bookform" onsubmit="return validatebook()" method="post">
      <label for= "make" class="label1">Make:</label> 
      	<input type="text" class="i1" name="make" value="${carforbook.getMake()}" readonly required ><br><br>

<label for= "model" class="label1">Model:</label> 
      	<input type="text"  class="i1" name="model" value="${carforbook.getModel()}" readonly required="true"><br><br>
 
 <label for= "type" class="label1">Type:</label> 
 <input type="text"  class="i1" name="type" value="${carforbook.getType()}" readonly required="true"><br><br>
 
 <label for= "color" class="label1">Color:</label> 
        <input type="text" class="i1" name="color" value="${carforbook.getColor()}" readonly required="true"><br><br>
 
  <label for= "model" class="label1">Seats:</label> 
  <input type="text"  class="i1" name="seats" value="${carforbook.getSeats()}" readonly required="true"><br><br>

<label for= "myear" class="label1">Manufactured Year:</label> 
<input class="i1"  name="myear" placeholder="YYYY" value="${carforbook.getMyear()}" readonly type="date"/><br><br>





 <label for= "Miles" class="label1">Miles Driven:</label> 
 <input type="text"  class="i1" name="miles"value="${carforbook.getMiles()}" readonly required="true"><br><br>     	

 <label for= "Miles" class="label1">Price per day in $:</label> 
 <input type="text"  class="i1" name="priceperday" value="${carforbook.getPriceperday()}" readonly required="true"><br><br> 
  

      	  <label for= "city" class="label1">City:</label> 
      	<input type="text" class="i1" name="city" value="${carforbook.getCity()}" readonly required="true" ><br><br>

      	  <label for= "state" class="label1">State:</label> 
      	<input type="text" class="i1" name="state" value="${carforbook.getState()}" readonly required="true"><br><br>

     <label for= "vin" class="label1">VIN:</label> 
      	<input type="text" class="i1" name="vin" value="${carforbook.getVin()}" readonly required="true"><br><br>
      	 	<fmt:formatDate value="${carforbook.getAvailfrom()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="availfrom" />
                
         <fmt:formatDate value="${carforbook.getAvailto()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="availto" />
      	
     
      	
    <label for= "availdate" class="label1">Available From:</label> 
        <input type="date" class="i1" name="availfrom" value="${availfrom}" readonly  required="true"><br><br>
  <label for= "availto" class="label1">Available To:</label> 
        <input type="date" class="i1" name="availto" value="${availto}" readonly  required="true"><br><br>
   <label for= "availto" class="label1">Booking Start Date :</label> 
    <input type="date" class="i1" name="startdate" placeholder="yyyy/mm/dd" required="true"><br><br>
      <label for= "availto" class="label1">Booking End Date:</label> 
     <input type="date" class="i1" name="enddate" placeholder="yyyy/mm/dd"  required="true"><br><br>
      <input type="submit" class="button" value="Confirm Booking"> 
      
       <%
			request.setAttribute("carowner",cb.getOwner());
       %>
       
      <input type="hidden" name="purpose" value="bookcar">
      <input type="hidden" name="ownerid" value="${carforbook.getOwner()}">

      
      </form>  
    