<%-- 
    Document   : customer_home
    Created on : Mar 29, 2020, 4:45:35 PM
    Author     : rahilkapadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="com.me.pojo.Customer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
     
     	function homevalidate(){
     		
     		  var seat = /^[1-8]$/;

     	      if(!document.forms["custhome"]["seats"].value.match(seat)){

     	          alert('No of seats should be between 1 and 8');
     	          return false;
     	      }
     	      
     	    /*  var c=/^[A-Za-z]{2,40}$/;

     	      if(!document.forms["custhome"]["city"].value.match(c)){
     	              alert('Only alphabets allowed for city');
     	              return false;

     	          } */
     	     var d = /^([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))$/;
     	    if(!document.forms["custhome"]["availfrom"].value.match(d)){

     	            alert('Enter available from: date  in yyyy/mm/dd');
     	            return false;
     	          }
  	
     		
     		return true;
     		
     	}
  
     </script>   

    </head>
    <body class= "bodydesign">
    <% 
       Customer cu = (Customer)session.getAttribute("customer");
    %>
        <%@ include file = "header.jsp" %>
       <h3>Welcome <%out.println(cu.getCfname()); %></h3>
 <div class= "container">
 <div class ="row">
 <div class="col-sm">
        
 <div class="form-group">
<form class="form-horizontal" name="custhome" onsubmit= "return homevalidate()" action="/mainpackage/car" method="post">
   

    <label for="search" class="label1">Search Cars By:</label>
		<br><br>
  <label for="search" class="label1">Type:</label>
  <select name = "type" class ="selectborder">
   <option value="hatchback"  class="select">Hatchback</option>
  <option value="sedan" class="select" >Sedan</option>
  <option value="suv"   class="select">SUV</option>
  <option value="sports" class="select">Sports</option>
 </select>
 <br><br>
 <label for= "model"  class="label1">Seats:</label> 
  <input type="text"  class="i1" name="seats" required><br><br>
   <label for= "city" class="label1">City:</label>
   	<select id="car" class ="selectborder" name="city" required>
		<c:forEach var="car" items="${sessionScope.allCity}">
		<option value="${car}">${car}</option>
		</c:forEach>
		</select>
		<br><br>
   
    
      <!--  	<input type="text" class="i1" name="city" required><br><br> -->
 
 <label for= "availdate" class="label1">Available From:</label> 
        <input type="date" class="i1" name="availfrom" placeholder="YYYY/MM/DD"  required><br><br>
  
  
  <button type="submit" class="btn btn-outline-success my-2 my-sm-0">Submit</button>
  <input type ="hidden" name="purpose" value="searchcar">
</form>

</div>
</div>

<div class="col-sm">
<form action ="/mainpackage/booking" method="post" class="contact2">
<input type = "submit" value="View your bookings">
<input type="hidden" name="purpose" value ="viewcustbooking">
</form>

<form method="post" action="/mainpackage/customer" class="contact2">
<input type ="submit" value="Edit profile" >
<input type="hidden" name="purpose" value="gotoupdate">
</form>
</div>

</div>
</div>
</body>

</html>
   