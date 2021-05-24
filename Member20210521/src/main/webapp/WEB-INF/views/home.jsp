<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<a href="joinpage">회원가입(memberJoin.jsp로 이동)</a> <br>
	<a href="loginpage">로그인(memberLogin.jsp로 이동)</a> <br>
	<!-- 단순이동이 아닌 DB에서 데이터를 가져와 jsp 에 출력 -->
	<a href="listpage">회원목록(memberList.jsp로 이동)</a> <br>
</body>
</html>
