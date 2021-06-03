<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardUpdate() {
		location.href='boardupdate?bnumber='+${board.bnumber};
	}
	
	function boardDelete() {
			location.href='boarddelete?bnumber='+${board.bnumber};
	}
</script>	
</head>
<body>
	<h2>boardview.jsp</h2>
	글번호 : ${board.bnumber} <br>
	작성자 : ${board.bwriter} <br>
	제목 : ${board.btitle} <br>
	내용 : ${board.bcontents} <br>
	파일: ${board.bfilename} <br>
	작성일자 : ${board.bdate} <br>
	조회수 : ${board.bhits} <br>
	이미지: <img src="resources/upload/${board.bfilename}" height="200" width="200"> <br>
	<c:if test="${sessionScope.loginMember == board.bwriter}">
		<!-- '본인'만 수정 -->
		<button onclick="boardUpdate()">수정버튼</button>
	</c:if>
	<c:if test="${sessionScope.loginMember == board.bwriter}">
		<!-- '본인'+'관리자' 삭제 (choose,when or 조건식 활용!) -->
		<button onclick="boardDelete()">삭제</button> <br>
	</c:if>	
	<a href="./">홈으로</a> <br>
	<a href="boardlist">리스트로 돌아가기</a> <br>
	
</body>
</html>