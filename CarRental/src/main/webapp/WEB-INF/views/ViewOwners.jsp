<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    <body class= "bodydesign">
   

<%@ include file = "header.jsp" %>
<div>
<table class="table table-bordered table-dark" >

  <tr>
    <th>Owner ID</th>
    <th>Fname</th>
    <th>Lname</th>
    <th>Date of Birth</th>
    <th>City</th>
    <th>License</th>
  </tr>
   <c:forEach var="owner" items="${ownerList}">
  <tr>
      <td><c:out value="${owner.getOid()}"/></td>
    <td><c:out value="${owner.getOfname()}"/></td>
    <td><c:out value="${owner.getOlname()}"/></td>
     <fmt:formatDate value="${owner.getOdob()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="dob" />
     <td><c:out value="${dob}"/></td>
    
    <td><c:out value="${owner.getOcity()}"/></td>
    <td><c:out value="${owner.getOlicense()}"/></td>
  

  </tr>
  </c:forEach>

</table>
</div>
