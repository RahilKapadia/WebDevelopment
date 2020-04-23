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
        	
        function validateown(){
        	
        	var n = /^[0-9]{1,4}$/;
        	if(!document.forms["byown"]["oid"].value.match(n)){
                alert('enter valid owner id');
              return false;

          }
        	
        	var b = /^[A-Za-z]*$/;
    		if(!document.forms["byown"]["oname"].value.match(b)){
   		 		alert('Only alphabets allowed for owner name');
          return false;
    		}
        	
        	
        	return true;
        	
        	
        	
        }	
        	
        	
        
        
        </script>
    </head>
    <body class= "bodydesign">
   

<%@ include file = "header.jsp" %>

<h3> Search car by filters</h3>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-6">
      <form method="post" name="bycust"  action="/mainpackage/car" class="contact2 w-75">
      <select id="car" name="city" required>
		<c:forEach var="car" items="${sessionScope.allCity}">
		<option value="${car}">${car}</option>
		</c:forEach>
		</select> <br><br>
 <!--   <input type="text" name="city" placeholder="enter city"  > <br><br> -->
<input type ="submit" value="Search by City" >
<input type="hidden" name="purpose" value="carsbycity">
</form>
   
          <form method="post" name="bystate" onsubmit="return validatestate()"  action="/mainpackage/car" class="contact2 w-75">
          <input type="text" name="state" placeholder="enter state initials"  > <br><br>
<input type ="submit" value="Search by State" >
<input type="hidden" name="purpose" value="carsbystate">
</form>
    </div>
    <div class="col-sm-6">
            <form method="post" name="byown" onsubmit="return validateown()" action="/mainpackage/car" class="contact2 w-75">
   <input type="text" name="oid" placeholder="enter owner id"> <br><br>  
   <input type="text" name="oname" placeholder="enter owner name"> <br><br>         
<input type ="submit" value="Search by Owner" >
<input type="hidden" name="purpose" value="carbyowner">
</form>

        <form method="post" action="/mainpackage/car" class="contact2 w-75">
          <select name = "type" class ="selectborder">
   <option value="hatchback"  class="select">Hatchback</option>
  <option value="sedan" class="select" >Sedan</option>
  <option value="suv"   class="select">SUV</option>
  <option value="sports" class="select">Sports</option>
 </select> <br><br>
<input type ="submit" value="Search by Type">
<input type="hidden" name="purpose" value="carbytype">
</form>





    </div>
 
 
  </div>
</div>


</body>
</html>