<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>memberList.jsp</h2>
	
	<!-- var속성: 현 위치에서 사용할 변수이름(반복용변수)
		item속성: mav에 담을 때 지정한 이름 -->
	<c:forEach var="data" items="${mList}">
	${data} <br>
	</c:forEach>
	
	<div>
	<table>
		<c:forEach var="value" items="${mList}">
		<tr>
			<td>${value.mid}</td>
			<td>${value.mPassword}</td>
			<td>${value.mName}</td>
			<td>${value.mEmail}</td>
		</tr>	
		</c:forEach>
	</table>
	</div>
	
	<a href="./">홈으로</a>
</body>
</html>