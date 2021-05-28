<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function update() {
		location.href="boardupdate";
	}
</script>
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
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.bnumber}</td>
				<td>${board.bwriter}</td>
				<!-- DB에서'내용'을 포함해 가져와야 하는 링크 -->
				<td><a href="boardview?bnumber=${board.bnumber}">${board.btitle}</a></td>
				<td>${board.bdate}</td>
				<td>${board.bhits}</td>
			</tr>	
		</c:forEach>
	</table>
	</div>
	
	<a href="./">홈으로</a>
</body>
</html>