<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logout() {
		location.href="logout";
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
	<a href="mypage">마이페이지</a>
	<button onclick="logout()">로그아웃</button> <br>
	로그인아이디: ${sessionScope.loginMember} <br>
	<h2>${sessionScope.loginMember} 님 반갑습니다!!</h2>
	
	<div>
	<c:if test="${sessionScope.loginMember eq 'admin'}">
		<a href="memberlist">회원목록조회(관리자전용)</a>
	</c:if>
	</div>
	
	<div>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
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
	
	<a href="./writepage">글쓰기</a> <br>
	<a href="./">홈으로 돌아가기</a>	
</body>
</html>