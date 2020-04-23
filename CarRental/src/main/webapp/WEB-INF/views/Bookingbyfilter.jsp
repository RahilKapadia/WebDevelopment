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
  /*       function validatecity(){
        	var c=/^[A-Za-z]{2,40}$/;

            if(!document.forms["bycity"]["city"].value.match(c)) {
                    alert('Only alphabets allowed for city');
                    return false;

                }
            
            return true;
        } */
        
        function validatestate(){
            
          var s = /^(A[LKSZRAEP]|C[AOT]|D[EC]|F[LM]|G[AU]|HI|I[ADLN]|K[SY]|LA|M[ADEHINOPST]|N[CDEHJMVY]|O[HKR]|P[ARW]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY])$/;
                if(!document.forms["bystate"]["state"].value.match(s)){
                      alert('enter valid state initials');
                    return false;

                }
        	
        	return true;
        }
        	
        function validatecust(){
        	
        	var n = /^[0-9]{1,4}$/;
        	if(!document.forms["bycust"]["cid"].value.match(n)){
                alert('enter valid customer id');
              return false;

          }
        	
        	var b = /^[A-Za-z]*$/;
    		if(!document.forms["bycust"]["cname"].value.match(b)){
   		 		alert('Only alphabets allowed for customername');
          return false;
    		}
        	
        	
        	return true;
        	
        	
        	
        }	
        function validDate(){
        	
        	var s = document.forms["bydate"]["startdate"].value;
            var e = document.forms["bydate"]["enddate"].value;
            var d = /^([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))$/;
            if(!document.forms["bydate"]["startdate"].value.match(d)){

                alert('Startdate must be in yyyy/mm/dd format!');

                return false;

              }

              if(!document.forms["bydate"]["enddate"].value.match(d)){

                alert(' Enddate must be in yyyy/mm/dd format!');

                return false;
                
              }
              if(Startdate > Enddate)
              {
                        alert("End date must be after start date");    
                        
                         return false;
              }
        	
        	return true;
        	
        	
        	
        }
        	
        
        
        </script>
        
        
        
        
        
        
    </head>
    <body class= "bodydesign">
   

<%@ include file = "header.jsp" %>

<h3> Search booking by filters</h3>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-6">
      <form method="post" name="bycity" action="/mainpackage/booking" class="contact2 w-75">
      <select id="car" name="city" required>
		<c:forEach var="car" items="${sessionScope.allCity}">
		<option value="${car}">${car}</option>
		</c:forEach>
		</select> <br><br>
 <!--  <input type="text" name="city" placeholder="enter city" required > <br><br> -->
<input type ="submit" value="Search by City"  >

<input type="hidden" name="purpose" value="bookingbycity">
</form>
   
          <form method="post" name="bystate" onsubmit="return validatestate()"  action="/mainpackage/booking" class="contact2 w-75">
          <input type="text" name="state" placeholder="enter state initials" required   > <br><br>
<input type ="submit" value="Search by State" >
<input type="hidden" name="purpose" value="bookingbystate">
</form>
         <form method="post" name="bydate" onsubmit="validatedate()"   action="/mainpackage/booking" class="contact2 w-75">
          <input type="text" name="startdate" placeholder="start date" required   > <br><br>
          <input type="text" name="enddate" placeholder="end date" required   > <br><br>
<input type ="submit" value="Search by Date" >
<input type="hidden" name="purpose" value="bookingbydate">
</form>





    </div>
    <div class="col-sm-6">
            <form method="post" name="bycust" onsubmit="return validatecust()" action="/mainpackage/booking" class="contact2 w-75">
   <input type="text" name="cid" placeholder="enter customer id" required> <br><br>  
   <input type="text" name="cname" placeholder="enter customer name" required> <br><br>         
<input type ="submit" value="Search by Customer"  >
<input type="hidden" name="purpose" value="bookingbycustomer">
</form>

        <form method="post" action="/mainpackage/booking" class="contact2 w-75">
          <select name = "type" class ="selectborder">
   <option value="hatchback"  class="select">Hatchback</option>
  <option value="sedan" class="select" >Sedan</option>
  <option value="suv"   class="select">SUV</option>
  <option value="sports" class="select">Sports</option>
 </select> <br><br>
<input type ="submit" value="Search by Type">
<input type="hidden" name="purpose" value="bookingbytype">
</form>





    </div>
 
 
  </div>
</div>


</body>
</html>