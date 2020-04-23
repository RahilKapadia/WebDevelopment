<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="com.me.pojo.Owner" %>
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
    <body class="bodydesign">
    <% 
       Owner o1 = (Owner)session.getAttribute("owner");
    %>
        <%@ include file = "header.jsp" %>

     <h3>Welcome ${owner.getOfname()}</h3>
     <div class = "container">
     <div class = "row">
     <div class="col-sm-4">
<form class="contact2 w-75" method="post" action="/mainpackage/owner">
<input type ="submit" value="Edit profile" >
<input type="hidden" name="purpose" value="gotoupdate">
</form>

<form class="contact2 w-75" method="post" action="/mainpackage/owner">
<input type ="submit" value="Add Car" >
<input type="hidden" name="purpose" value="gotoaddcar">
</form>
</div>
    <div class="col-sm-4">
<form class="contact2 w-75" method="post" action="/mainpackage/car">
<input type ="submit" value="View My Cars" >
<input type="hidden" name="purpose" value="viewownercars">
<input type="hidden" value="${owner}" name="owner">
</form>

<form class="contact2 w-75" method="post" action="/mainpackage/booking">
<input type ="submit" value="View Car Bookings" >
<input type="hidden" name="purpose" value="viewbyowner">
<input type="hidden" name="ownerid" value="${owner.getOid()}">
</form>


</div>

</div>
</div>
</body>
</html>