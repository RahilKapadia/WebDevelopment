<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="com.me.pojo.Customer" %>
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

<h3> You are logged in as System Admin</h3>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-6">
      <form method="post" action="/mainpackage/customer" class="contact2">
<input type ="submit" value="View Customers" >
<input type="hidden" name="purpose" value="allCustomer">
</form>
   
          <form method="post" action="/mainpackage/owner" class="contact2">
<input type ="submit" value="View Owners" >
<input type="hidden" name="purpose" value="allOwner">
</form>
    
            <form method="post" action="/mainpackage/car" class="contact2">
<input type ="submit" value="View Cars" >
<input type="hidden" name="purpose" value="allCars">
</form>

            <form method="post" action="/mainpackage/car" class="contact2">
<input type ="submit" value="Cars by filter" >
<input type="hidden" name="purpose" value="carbyfilter">
</form>




    </div>
 <div class="col-sm-6">
      <form method="post" action="/mainpackage/booking" class="contact2">
<input type ="submit" value="View Bookings" >
<input type="hidden" name="purpose" value="allBookings">
</form>

  <form method="post" action="/mainpackage/booking" class="contact2">

<input type ="submit" value="Booking by filters" >
<input type="hidden" name="purpose" value="bookingbyfilter">
</form>

  <form method="post" action="/mainpackage/booking" class="contact2">

<input type ="submit" value="View deleted bookings" >
<input type="hidden" name="purpose" value="bookingdeleted">
</form>


</div>   
 
  </div>
</div>


</body>
</html>