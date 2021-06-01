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
		location.href='boardupdate?bnumber='+${board.bnumber};
	}
	
	function boardDelete() {
		var pwd = prompt('비밀번호를 입력하세요.');
		var bpassword = '${board.bpassword}';
		if(pwd == bpassword) {
			location.href='boarddelete?bnumber='+${board.bnumber};
		} else {
			alert('비밀번호가 틀립니다!!');
		}
	}
</script>	
</head>
<body>
	<h2>boardview.jsp</h2>
	글번호 : ${board.bnumber} <br>
	작성자 : ${board.bwriter} <br>
	제목 : ${board.btitle} <br>
	글비번 : ${board.bpassword} <br>
	내용 : ${board.bcontents} <br>
	작성일자 : ${board.bdate} <br>
	조회수 : ${board.bhits} <br>
	첨부파일: ${board.bfilename} <br>
	이미지: <img src="resources/upload/${board.bfilename}" height="200" width="200"> <br>
	<a href="./">홈으로</a> <br>
	<a href="boardlist">리스트로 돌아가기</a> <br>
	
	<!-- 수정링크/버튼 만들고 수정기능 구현 -->
	<a href="boardupdate?bnumber=${board.bnumber}">수정</a> <br>
	<button onclick="update()">수정버튼</button>
	<!-- 1. 위의 수정링크를 클릭하면 Controller-Service-DAO-DB를 거쳐 데이터를 가지고 boardupdate.jsp를 출력함.
		 2. 그리고 boardupdate.jsp에서 수정할 내용을 입력받고 DB에 update 쿼리를 수행해줘야함. -->
	<!-- 주소값 요청이 잘 이루어지고 있는지 확인! -->
	<button onclick="boardDelete()">삭제</button> <br>
	
	<a href="paging?page=${page}">페이징목록으로 돌아가기</a>
</body>
</html>