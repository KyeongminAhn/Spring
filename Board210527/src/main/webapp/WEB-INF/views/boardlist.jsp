<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, tr, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h2>boardlist.jsp</h2>
	
	<div>
	<table>
		<tr>
			<th>글제목</th>
			<th>글비번</th>
			<th>작성자</th>
			<th>내용</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.btitle}</td>
				<td>${board.bpassword}</td>
				<td>${board.bwriter}</td>
				<td>${board.bcontents}</td>
			</tr>	
		</c:forEach>
	</table>
	</div>
	
	<a href="./">홈으로</a>
</body>
</html>