<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="com.me.pojo.Car" %>
<%@page import ="com.me.pojo.Booking" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href= "<%= request.getContextPath() %>/resources/Styles.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <title>JSP Page</title>
       
    </head>
    <body class= "bodydesign">

        <%@ include file = "header.jsp" %>
 
      <h1> Edit Booking: </h1>
      <form class="formstyle" action="/mainpackage/booking" method="post">
      
           <label for= "make" class="label1">Booking Id:</label> 
      	<input type="text" class="i1" name="bookingId" value="${book.getBookingId()}" required disabled ><br><br>
        
             <label for= "make" class="label1">Car Id:</label> 
      	<input type="text" class="i1" name="make" value="${book.getCar().getCarid()}" required disabled ><br><br>
      
          <label for= "make" class="label1">Customer Id:</label> 
      	<input type="text" class="i1" name="customerId" value="${book.getCustomer().getCid()}" required disabled><br><br>
      
        <label for= "make" class="label1">Customer Name:</label> 
      	<input type="text" class="i1" name="customerName" value="${book.getCustomer().getCfname()}" required disabled><br><br>
      
         <label for= "make" class="label1">Owner Id:</label> 
      	<input type="text" class="i1" name="ownerId" value="${book.getCar().getOwner().getOid()}" required disabled ><br><br>
      
       <label for= "make" class="label1">Owner Name:</label> 
      	<input type="text" class="i1" name="ownerId" value="${book.getCar().getOwner().getOfname()}" required disabled><br><br>
      
      
      
      <label for= "make" class="label1">Make:</label> 
      	<input type="text" class="i1" name="make" value="${book.getCar().getMake()}" required disabled><br><br>

<label for= "model" class="label1">Model:</label> 
      	<input type="text"  class="i1" name="model" value="${book.getCar().getModel()}" required disabled><br><br> 	

 <label for= "Miles" class="label1">Price per day in $:</label> 
 <input type="text"  class="i1" name="priceperday" value="${book.getCar().getPriceperday()}" required disabled><br><br> 
  

     <label for= "vin" class="label1">VIN:</label> 
      	<input type="text" class="i1" name="vin" value="${book.getCar().getVin()}" required disabled><br><br>
      	
      	  <fmt:formatDate value="${book.getCar().getAvailfrom()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="availfrom" />
                
         <fmt:formatDate value="${book.getCar().getAvailto()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="availto" />
      	
      	
      	
      	
      	
      	
      	
    <label for= "availdate" class="label1">Available From:</label> 
        <input type="date" class="i1" name="availfrom" value="${availfrom}" readonly  required> <br><br>
  <label for= "availto" class="label1">Available To:</label> 
        <input type="date" class="i1" name="availto" value="${availto}" readonly  required ><br><br>
        
     <fmt:formatDate value="${book.getStartDate()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="startdate" />
                
         <fmt:formatDate value="${book.getEndDate()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="enddate" />    
        
        
        
        
        
        
   <label for= "availto" class="label1">Booking Start Date :</label> 
    <input type="date" class="i1" name="startdate" value="${startdate}" required ><br><br>
      <label for= "availto" class="label1">Booking End Date:</label> 
     <input type="date" class="i1" name="enddate" value="${enddate}"  required ><br><br>
      <input type="submit" class="button" value="Update Booking"> 
      
      <input type="hidden" name="bookId" value="${book.getBookingId()}">
      <input type="hidden" name="purpose" value="updateBooking">
     <%  
     Booking book = (Booking) request.getAttribute("book");
     request.setAttribute("carbook",book.getCar()); %>

      
      </form>  
    </body>
    </html>