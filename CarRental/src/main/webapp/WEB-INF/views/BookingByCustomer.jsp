<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
       
    </head>
    <body class= "bodydesign">

        <%@ include file = "header.jsp" %>
     <h1> Your booked cars:</h1>
     
     <div>
<table class="table table-dark" >
  <tr>
  	<th> Booking ID </th>
    <th>CarID</th>
    <th>Model</th>
    <th>Owner Id</th>
    <th>Owner Name</th>
    <th>Booking from</th>
    <th>Booking to</th>
      <th> Price/Day</th>
      <th> Booking Amount </th>
     </tr>
      
   <c:forEach var="book" items="${getByCustomer}">
  <tr>
     <td><c:out value="${book.getBookingId()}"/></td>
    <td><c:out value="${book.getCar().getCarid()}"/></td>
    <td><c:out value="${book.getCar().getModel()}"/></td>
     <td><c:out value="${book.getCar().getOwner().getOid()}"/></td>
     <td><c:out value="${book.getCar().getOwner().getOfname()}"/></td>
     <fmt:formatDate value="${book.getStartDate()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="startdate" />
                
         <fmt:formatDate value="${book.getEndDate()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="enddate" />
    
     <td><c:out value="${startdate}"/></td>
     <td><c:out value="${enddate}"/></td>
     <td><c:out value="${book.getCar().getPriceperday()}"/></td>
      <td><c:out value="${book.getBookingAmount()}"/></td>
    
  </tr>
  </c:forEach>

</table>
</div>