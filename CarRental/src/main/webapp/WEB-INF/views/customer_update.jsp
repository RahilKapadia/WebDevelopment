
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="com.me.pojo.Customer" %>
<%@page import = "java.text.SimpleDateFormat"%>
<%@page import= "java.util.Date"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href= "<%= request.getContextPath() %>/resources/Styles.css"> </HEAD>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<nav class="navbar navbar-expand-lg navbar-dark bg-light">
  <a class="navbar-brand" >
	<div class="logo-image">
            <img src="resources/images/logo.png" class="img-fluid">
      </div>
  </a>
      </nav> 
        <title>JSP Page</title>
        <script>
        
        function validateform(){
        	
        	var x = document.forms["newcustform"]["username"].value;
        	var u = /^[a-zA-Z0-9]*$/;
        	 if (x == "") {
        		    alert('Name must be filled out');
        		    return false;
        	 }
        	 if(!document.forms["newcustform"]["username"].value.match(u)){
        		 	  alert('Only alphanumeric allowed for username');
              return false;
        	 }
        	 
        		    
        	var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,20}$/;
        	if(!document.forms["newcustform"]["password"].value.match(passw)) 
        		{ 
        		    	alert('password must have atleast 3 characters and contain an uppercase, lowercase, digit');
                  return false;
        		    }
  
        
        	var b = /^[A-Za-z]*$/;
        		if(!document.forms["newcustform"]["cfname"].value.match(b)){
       		 		alert('Only alphabets allowed for fist name');
              return false;
        		}
        	var c = /^[A-Za-z]*$/;
        	if(!document.forms["newcustform"]["clname"].value.match(c)){
       		 	 alert('Only alphabets allowed for  last name');
            return false;
        	}
            var d = /^([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))$/;
          if(!document.forms["newcustform"]["cdob"].value.match(d)){

            alert('Enter date of birth in yyyy/mm/dd');
            return false;
          }
          var street = /^[ A-Za-z0-9_@./#&+-]{4,80}$/;
          if(!document.forms["newcustform"]["cstreet"].value.match(street)){
              alert('Enter valid street address');
              return false;

          }


          var c = /^[A-Za-z]{2,40}$/;

          if(!document.forms["newcustform"]["ccity"].value.match(c)){
              alert('Only alphabets allowed for city');
              return false;

          }
          var s = /^(A[LKSZRAEP]|C[AOT]|D[EC]|F[LM]|G[AU]|HI|I[ADLN]|K[SY]|LA|M[ADEHINOPST]|N[CDEHJMVY]|O[HKR]|P[ARW]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY])$/;
          if(!document.forms["newcustform"]["cstate"].value.match(s)){
                alert('enter valid state initials');
              return false;

          }

          var zip = /^\d{5}$/;
           if(!document.forms["newcustform"]["czip"].value.match(zip)){

            alert('enter 5 digit zip code');
            return false;
           }


          var phone = /^\d{10}$/;
          if(!document.forms["newcustform"]["ccontact"].value.match(phone)){

              alert('enter 10 digit phone');
            return false;


          }

        var email = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})$/;
         if(!document.forms["newcustform"]["cemail"].value.match(email)){

            alert('enter email in proper format');
            return false;
           }
         var lic = /^[A-Z]{2}[0-9]{2,9}$/;
          if(!document.forms["newcustform"]["clicense"].value.match(lic)){

            alert('License alphanumeric  eg:MA020');
            return false;
           }
           return true;

        }
        
        
        </script>
       
        
    </head>
<Body class="bodydesign">
	 <h1> Edit your profile: </h1>
    <form class="contact1"onsubmit="return validateform()" name="newcustform" action="/mainpackage/customer" method= "post">
   
    <% Customer custom = (Customer)session.getAttribute("customer");
    
    
    	pageContext.setAttribute("customer", custom);
    
    System.out.println(custom.getCid()); 
    %>
    <label for= "id" class="label1">Id:</label> 
<input type="text" class="i1" name="cid"  value="${customer.getCid()}" readonly  required><br><br>

<label for= "username" class="label1">User Name:</label> 
      	<input type="text" class="i1" name="username"  value="${customer.username}" required><br><br>
<label for= "password" class="label1">Password:</label> 
<input type="password" class="i1" name="password"  value="${customer.password}" required><br><br>


<label for= "fname" class="label1">First Name:</label> 
<input type="text" class="i1" name="cfname"  value="${customer.getCfname()}" required><br><br>

<label for= "lname" class="label1">Last Name:</label> 
      	<input type="text"  class="i1" name="clname"  value="${customer.getClname()}" required><br><br>

<fmt:formatDate value="${customer.getCdob()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="dob" /> 
<label for= "dob" class="label1">Date of Birth:</label> 
<input class="i1"  name="cdob"  type="date"  value="${dob}" required><br><br>

 <label for= "gender"class="label1" >Gender:</label> 
  <input type="radio" id="male" name="cgender" value="male" required >
<label for="male" class="label1">Male</label>
<input type="radio" id="female" name="cgender" value="female">
<label for="female" class="label1">Female</label><br>
<br>
  <label for= "street" class="label1">Street:</label> 
      	<input type="text" class="i1" name="cstreet"  value="${customer.getCstreet()}" required><br><br>

      	  <label for= "city" class="label1">City:</label> 
      	<input type="text" class="i1" name="ccity" value="${customer.getCcity()}" required ><br><br>

      	  <label for= "state" class="label1">State:</label> 
      	<input type="text" class="i1" name="cstate"  value="${customer.getCstate()}" required ><br><br>

     <label for= "zip" class="label1">Zip Code:</label> 
      	<input type="text" class="i1" name="czip"  value="${customer.getCzip()}" required ><br><br>
     <label for= "contact" class="label1">Contact:</label> 
      	<input type="text" class="i1" name="ccontact"  value="${customer.getCcontact()}" required ><br><br>
     <label for= "email"class="label1" >Email:</label> 
      	<input type="text" class="i1" name="cemail"  value="${customer.getCemail()}" required><br><br>
     

     <label for= "license"class="label1" >License No:</label> 
      	<input type="text" class="i1" name="clicense"  value="${customer.getClicense()}" required><br><br>

<input type="submit" class="button" value="Submit">
<input type="hidden" name="purpose" value="updatecustomer">
<br><br> 



    </form>

</Body>
</html>
