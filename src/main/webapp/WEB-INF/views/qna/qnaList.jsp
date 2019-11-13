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
	<div>
		<form id="frm" action="./qnaList">
			<input type="hidden" id="curPage" value="1" name="curPage">
			<select name="kind">
				<option id="kt" value="kt">Title</option>
				<option id="kc" value="kc">Contents</option>
				<option id="kw" value="kw">Writer</option>
			</select>
			
			<input type="text" name="search" value="${pager.search}">
			<button>Search</button>
		</form>
	</div>

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
						<td><a href="./qnaSelect?num=${dto.num}">${dto.title}</a></td>
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
			<c:if test="${pager.curBlock gt 1}">
				<span id="${pager.startNum-1}" class="list">Prev</span>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">			
				<span id="${i}" class="list">${i}</span>
			</c:forEach>
			<c:if test="${pager.curBlock lt pager.totalBlock}">
				<span id="${pager.lastNum+1}" class="list">Next</span>
			</c:if>
		</div>
		
		<a href="qnaWrite" class="btn btn-info">Write</a>
		
	</div>
	
	<script type="text/javascript">
		var kind = '${pager.kind}'
		if(kind == ''){
			kind = "kt";
		}
		$("#"+kind).prop("selected", true); /* prop은 변하는 값 */
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id")); /* attr은 속성 그대로 가져오고싶을 때 */
			$("#frm").submit();
		});
	</script>
</body>
</html>