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
	<a href="writepage">글쓰기(boardwrite.jsp로 이동)</a> <br>
	<!-- DB에서 정보를 가져와서 boardlist.jsp에 출력 -->
	<a href="boardlist">글목록(boardlist.jsp로 이동)</a> <br>
</body>
</html>
