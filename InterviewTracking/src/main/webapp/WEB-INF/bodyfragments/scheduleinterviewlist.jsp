<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule Interview List</title>
</head>
<body>

<div class="container"  >

<h2 style="padding: 30px">Scheduled Interview List</h2>

<%@include file="businessMessage.jsp" %>
<table class="table bg-light text-dark">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
      <th scope="col">Phone Number</th>
      <th scope="col">scheduleWith</th>
      <th scope="col">Date</th>  
      <th scope="col">Time</th>    
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>     
      <td>${li.firstName}</td>
      <td>${li.lastName}</td>
      <td>${li.email}</td>
      <td>${li.phoneNumber}</td>
      <td>${li.scheduleWith}</td>
      <td>${li.date}</td>
      <td>${li.time}</td>  
      <td>
      <c:choose>
      
      <c:when test="${user.userRole == 'HR'}">
       <a class="btn btn-primary" href="${pageContext.request.contextPath}/feedback?id=${li.id}" style="margin: 5px">Write Feedback</a>
      </c:when>
      
      <c:when test="${user.userRole == 'Tech'}">
       <a class="btn btn-primary" href="${pageContext.request.contextPath}/feedback?id=${li.id}" style="margin: 5px">Write Feedback</a>
      </c:when>
      
      <c:otherwise>
      
      
      </c:otherwise>
      
      </c:choose>
   
      
      </td> 
    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>