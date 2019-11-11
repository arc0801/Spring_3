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
	<div class="container">
		<h2>QnA</h2>
		<table class="table">
			<thead>
				<tr class="info"><th>NO</th><th>SUBJECT</th><th>NAME</th><th>DATE</th><th>HIT</th><th>REF</th><th>STEP</th><th>DEPTH</th></tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td>${dto.title}</td>
						<td>${dto.writer}</td>
						<td>${dto.reg_date}</td>
						<td>${dto.hit}</td>
						<td>${dto.ref}</td>
						<td>${dto.step}</td>
						<td>${dto.depth}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li><a href="./qnaList?curPage=${pager.startNum-1}" class="btn btn-info">Prev</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">			
					<li><a href="./qnaList?curPage=${i}">${i}</a></li>
				</c:forEach>
				<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li><a href="./qnaList?curPage=${pager.lastNum+1}" class="btn btn-info">Next</a></li>
				</c:if>
			</ul>
		</div>
		
		<a href="qnaWrite" class="btn btn-info">Write</a>
		
	</div>
</body>
</html>