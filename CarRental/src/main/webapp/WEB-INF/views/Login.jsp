<%-- 
    Document   : Login
    Created on : Mar 28, 2020, 11:25:00 AM
    Author     : rahilkapadia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head><title> Car Zone </title>
       
          <link rel="stylesheet" type="text/css" href= "<%= request.getContextPath() %>/resources/Styles.css">
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
    <script>
    function validateform(){
    	var x = document.forms["loginform"]["username"].value;
    	 if (x == "") {
    		    alert('User Name must be filled out');
    		    return false;
    	 }
    		    
    		    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,20}$/;
    		    if(document.forms["loginform"]["password"].value.match(passw)) 
    		    { 
    		    return true;
    		    }
    		    else
    		    { 
    		    alert('Enter password in correct format...!');
    		    return false;
    		    }
    			}
    
    function passvalidate(){
    	var x = document.forms["loginform"]["username"].value;
   	 if (x == "") {
   		    alert('User Name must be filled out');
   		    return false;
   	 }
    	
   	 return true;
    	
    }
    
    </script>  
    </head>
       
    <body  class="bodydesign">
           
          <form name="loginform" action ="login.htm" onsubmit="return validateform()" method ="post" class="contact2"> 
              <label for= "username" class="label1" >Username:</label> 
      	<input type="text" class="i1" name="username"><br><br>
     <label for="password" class="label1">Password: </label> 
     <input type = "password" placeholder="eg aA1" id="txtPassword" class = "i1" name="password"> <br><br> 
     

<label for = "User Type" class="label1"> Role: </label>
 <select name = "role" class ="selectborder">
  <option value="Admin" class="select" > Admin</option>
  <option value="Customer"   class="select">Customer</option>
  <option value="Car Owner"  class="select">Car Owner</option>
 
</select>
<br><br>
<input type="submit" class="button" value="Submit">
<br><br>

<input type="hidden" value="newform" name ="newoption">
</form>

<form action ="login.htm" method = "post"  class="contact2">
<input type = "submit" value="Forgot Password?">
<input type="hidden" value="pass" name ="newoption">
</form>


<form action ="login.htm" method = "post" class="contact2">
<input type = "submit" value="New Customer?">
<input type="hidden" value="newcustomer" name ="newoption">
</form>

<form action ="login.htm" method = "post" class="contact2">
<input type = "submit"  value="New Owner?">
<input type="hidden" value="newowner" name ="newoption">
</form>








    </body>
</html>

