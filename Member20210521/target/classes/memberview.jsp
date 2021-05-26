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
	<h2>memberview.jsp</h2>
	<!-- 조회한 해당 회원의 정보만 출력 -->
	<!-- EL(Expression Language) -->
	아이디: ${result.mId} <br>
	비밀번호: ${result.mPassword} <br>
	이름: ${result.mName} <br>
	이메일: ${result.mEmail} <br>
	
	<a href="./">홈으로</a>
	<a href="listpage">리스트로 돌아가기</a>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>상세조회</th>
		</tr>
		<c:forEach var="member" items="${mList}">
			<tr>
				<td>${member.mId}</td>
				<td>${member.mPassword}</td>
				<td>${member.mName}</td>
				<td>${member.mEmail}</td>
				<!-- 조회 링크를 클릭하면 memberview.jsp에 해당 회원의 정보만 출력 -->
				<!-- 여기선 id를 기준으로 잡아본다. -->
				<td><a href="memberview?mId=${value.mId}">조회</a></td>
				<!-- http://localhost:8081/member/memberview?mId=id1
						memberview 라는 주소 요청하면서 mId 파라미터에 id1을 담아서 간다 -->
			</tr>	
		</c:forEach>
	</table>
</body>
</html>