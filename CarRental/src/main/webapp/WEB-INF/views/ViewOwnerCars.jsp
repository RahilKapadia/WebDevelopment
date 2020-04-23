<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import ="com.me.pojo.Customer" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import = "java.util.Date" %>
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
<div>
<table class="table table-bordered table-dark" >

  <tr>
    <th>CarID</th>
    <th>Make</th>
    <th>Model</th>
    <th>Seats</th>
    <th>Type</th>
      <th>Avail from</th>
      <th> Avail to</th>
      <th> Price/Day</th>
      </tr>
      
   <c:forEach var="car" items="${ownercars}">
  <tr>
      <td><c:out value="${car.getCarid()}"/></td>
    <td><c:out value="${car.getMake()}"/></td>
    <td><c:out value="${car.getModel()}"/></td>
    <td><c:out value="${car.getSeats()}"/></td>
    <td><c:out value="${car.getType()}"/></td>
        <fmt:formatDate value="${car.getAvailfrom()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="availfrom" />
                
         <fmt:formatDate value="${car.getAvailto()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="availto" />
    
    
    
    
    <td><c:out value="${availfrom}"/></td>
    <td><c:out value="${availto}"/></td>
     <td><c:out value="${car.getPriceperday()}"/></td>
    <td><form method="post" action="/mainpackage/car">
<input type ="submit" value="Modify" >
<input type="hidden" name="purpose" value="modify">
<input type="hidden" value="${car.getCarid()}" name="id">
</form></td> 

  </tr>
  </c:forEach>

</table>
</div>
</body>
</html>