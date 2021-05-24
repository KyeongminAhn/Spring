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
	<h2>memberList.jsp</h2>
	
	<c:forEach var="data" items="${mList}">
	${data} <br>
	</c:forEach>
	
	<div>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>상세조회</th>
		</tr>
		<c:forEach var="value" items="${mList}">
			<tr>
				<td>${value.mId}</td>
				<td>${value.mPassword}</td>
				<td>${value.mName}</td>
				<td>${value.mEmail}</td>
				<!-- 조회 링크를 클릭하면 memberview.jsp에 해당 회원의 정보만 출력 -->
				<!-- 여기선 id를 기준으로 잡아본다. -->
				<td><a href="memberview?mId=${value.mId}">조회</a></td>
				<!-- http://localhost:8081/member/memberview?mId=id1
						memberview 라는 주소 요청하면서 mId 파라미터에 id1을 담아서 간다 -->
			</tr>	
		</c:forEach>
	</table>
	</div>
	
	<a href="./">홈으로</a>
</body>
</html>