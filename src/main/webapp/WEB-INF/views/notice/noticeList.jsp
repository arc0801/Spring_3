<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
<c:import url="../layout/nav.jsp" />
	
	<div class="container">
	  <h2>Notice</h2>
	  <table class="table">
	    <thead>
	      <tr class="info"><th>NO</th><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th></tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${list}" var="dto" varStatus="st">
		      <tr>
		        <td>${dto.num}</td>
		        <td><a href="noticeSelect?num=${dto.num}">${dto.title}</a></td>
		        <td>${dto.writer}</td>
		        <td>${dto.reg_date}</td>
		        <td>${dto.hit}</td>
		       </tr>
	    	</c:forEach>
	    </tbody>
	  </table>
	  
	  <!-- session member, memberDTO -->
	  <%-- <c:if test="${not empty sessionScope.member}"> --%>
	  	<a href="noticeWrite" class="btn btn-info">Write</a>
	  <%-- </c:if> --%>
	</div>
	
	<%-- <img alt="" src="../resources/images/4.jpg">
	<a href="./noticeSelect?n=33">Select One</a>
	<a href="./noticeWrite">Notice Write</a>
	<h1>${list}</h1> --%>
</body>
</html>