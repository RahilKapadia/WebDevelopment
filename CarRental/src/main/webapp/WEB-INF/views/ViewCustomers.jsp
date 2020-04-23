<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<div>
<table class="table tabel-bordered table-dark" >

  <tr>
    <th>Customer ID</th>
    <th>Fname</th>
    <th>Lname</th>
    <th>Date of Birth </th>
    <th>City</th>
    <th>License</th>
  </tr>
   <c:forEach var="customer" items="${custList}">
  <tr>
      <td><c:out value="${customer.getCid()}"/></td>
    <td><c:out value="${customer.getCfname()}"/></td>
    <td><c:out value="${customer.getClname()}"/></td>
 <fmt:formatDate value="${customer.getCdob()}" 
                type="date" 
                pattern="yyyy/MM/dd"
                var="dob" />
    
    
    <td><c:out value="${dob}"/></td>
    <td><c:out value="${customer.getCcity()}"/></td>
    <td><c:out value="${customer.getClicense()}"/></td>

  </tr>
  </c:forEach>

</table>
</div>
