<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
         <link rel="stylesheet" type="text/css" href= "<%= request.getContextPath() %>/resources/Styles.css"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
   <script>   
    function validateform(){
      

      var p =/^[a-zA-Z0-9]{2,50}$/;
      if(!document.forms["carform"]["make"].value.match(p)){

        alert('Car make name must be alphanumeric and more than 1 character');
        return false;


      }
      var p1 =/^[a-zA-Z0-9]{1,50}$/;
       if(!document.forms["carform"]["model"].value.match(p1)){

        alert('Car model name must be alphanumeric');
        return false;


      }
      var a = /^[A-Za-z]{3,15}$/;
      if(!document.forms["carform"]["color"].value.match(a)){

         alert('Color name must contain alphabets and should be a valid name');
        return false;


      }
      var seat = /^[1-8]$/;

      if(!document.forms["carform"]["seats"].value.match(seat)){

          alert('No of seats should be between 1 and 8');
          return false;

      }

    
      var y = /^[0-9]{4}$/;
      if(!document.forms["carform"]["myear"].value.match(y)){
        alert('enter a valid value  for year');
        return false;
      } 

      if(document.forms["carform"]["myear"].value > 2020 || document.forms["carform"]["myear"].value < 1990){
        alert('enter year between 1990 and current year');
         return false;
       }

      var m = /^[0-9]{0,5}$/;
      if(!document.forms["carform"]["miles"].value.match(m)){

          alert('enter valid value for miles');
          return false;

      }

      var ppd = /^[0-9]{0,4}$/;
      if(!document.forms["carform"]["priceperday"].value.match(ppd)){


          alert('enter valid value for price per day');
          return false;

      }



      var c=/^[A-Za-z]{2,40}$/;

      if(!document.forms["carform"]["city"].value.match(c)){
              alert('Only alphabets allowed for city');
              return false;

          }
    var s = /^(A[LKSZRAEP]|C[AOT]|D[EC]|F[LM]|G[AU]|HI|I[ADLN]|K[SY]|LA|M[ADEHINOPST]|N[CDEHJMVY]|O[HKR]|P[ARW]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY])$/;
          if(!document.forms["carform"]["state"].value.match(s)){
                alert('enter valid state initials');
              return false;

          }



      var v = /^[0-9a-zA-Z]{2,9}$/;
      if(!document.forms["carform"]["vin"].value.match(v)){

        alert("enter appropriate  vin (alphanumeric)");
        return false;
      }




    var d = /^([12]\d{3}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01]))$/;
    if(!document.forms["carform"]["availfrom"].value.match(d)){

            alert('Enter available from: date  in yyyy/mm/dd');
            return false;
          }
    if(!document.forms["carform"]["availto"].value.match(d)){

            alert('Enter available to: date  in yyyy/mm/dd');
            return false;
          }
      var x= document.forms["carform"]["availfrom"].value;
      var y = document.forms["carform"]["availto"].value;


      var date1 = new Date(x);
      var date2 = new Date(y);

      if(date1 > date2)
      {
                alert("Available to must be greater than Available from");
                
                 return false;
      }

        return true;

    }
  </script>   
   
     </head>
    
<body class="bodydesign">
     <%@ include file = "header.jsp" %>
	<h1> Add Car  </h1>
    <div>
<form class="formstyle" name="carform" onsubmit="return validateform()"  action="/mainpackage/car" method="post">

  
  
<label for= "make" class="label1">Make:</label> 
      	<input type="text" class="i1" name="make" required="true"><br><br>

<label for= "model" class="label1">Model:</label> 
      	<input type="text"  class="i1" name="model" required="true"><br><br>
 
 <label for= "type" class="label1">Type:</label> 
  <select name = "type" class ="selectborder">
   <option value="hatchback"  class="select">Hatchback</option>
  <option value="sedan" class="select" >Sedan</option>
  <option value="suv"   class="select">SUV</option>
  <option value="sports" class="select">Sports</option>
 </select>
 <br><br>
  <label for= "color" class="label1">Color:</label> 
        <input type="text" class="i1" name="color" required="true"><br><br>
 
  <label for= "model" class="label1">Seats:</label> 
  <input type="text"  class="i1" name="seats" required="true"><br><br>

<label for= "myear" class="label1">Manufactured Year:</label> 
<input class="i1"  name="myear" placeholder="YYYY" type="date"/><br><br>





 <label for= "Miles" class="label1">Miles Driven:</label> 
 <input type="text"  class="i1" name="miles" required="true"><br><br>     	

 <label for= "Miles" class="label1">Price per day in $:</label> 
 <input type="text"  class="i1" name="priceperday" required="true"><br><br> 
  

      	  <label for= "city" class="label1">City:</label> 
      	<input type="text" class="i1" name="city" required="true"><br><br>

      	  <label for= "state" class="label1">State:</label> 
      	<input type="text" class="i1" name="state" required="true"><br><br>

     <label for= "vin" class="label1">VIN:</label> 
      	<input type="text" class="i1" name="vin" required="true"><br><br>
    <label for= "availdate" class="label1">Available From:</label> 
        <input type="date" class="i1" name="availfrom" placeholder="YYYY/MM/DD"  required="true"><br><br>
  <label for= "availto" class="label1">Available To:</label> 
        <input type="date" class="i1" name="availto" placeholder="YYYY/MM/DD"   required="true"><br><br>

<input type="submit" class="button" value="Submit">
<input type="hidden" name="purpose" value="addCar">
<br><br>

</form>
</div>
</body>
</html>
