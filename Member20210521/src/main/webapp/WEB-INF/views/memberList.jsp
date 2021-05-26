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
	
	로그인아이디: ${sessionScope.loginMember} <br>
	
	<div>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>상세조회</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="member" items="${mList}">
			<tr>
				<td>${member.mId}</td>
				<td>${member.mPassword}</td>
				<td>${member.mName}</td>
				<td>${member.mEmail}</td>
				<!-- 조회 링크를 클릭하면 memberview.jsp에 해당 회원의 정보만 출력 -->
				<!-- 여기선 id를 기준으로 잡아본다. -->
				<td><a href="memberview?mId=${member.mId}">조회</a></td>
				<!-- http://localhost:8081/member/memberview?mId=id1
						memberview 라는 주소 요청하면서 mId 파라미터에 id1을 담아서 간다 -->
				<td><button onclick="deletefn('${member.mId}')">삭제</button>
			</tr>	
		</c:forEach>
	
	</table>
	<script>
	/* 삭제든 수정이든 기준 데이터는 PK컬럼인 id! */
		function deletefn(id) {
			console.log('삭제할 아이디' + id);
			location.href="memberdelete?mId="+id;
			// location.href="mbmberdelete?mId=id;(X)
		}
	</script>
	</div>
	
	<a href="./">홈으로</a>
</body>
</html>