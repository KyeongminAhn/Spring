<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>memberview.jsp</h2>
	<!-- 조회한 해당 회원의 정보만 출력 -->
	아이디: ${result.mId} <br>
	비밀번호: ${result.mPassword} <br>
	이름: ${result.mName} <br>
	이메일: ${result.mEmail} <br>
	
	<a href="./">홈으로</a>
	<a href="listpage">리스트로 돌아가기</a>
</body>
</html>