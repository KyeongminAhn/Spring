<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>boardwrite.jsp</h2>	
		<form action="boardwrite" method="post" enctype="multipart/form-data">
		글제목: <input type="text" name="btitle"> <br>
		작성자: <input type="text" name="bwriter" value="${sessionScope.loginMember}" readonly><br>
		내용: <textarea name="bcontents" rows="5"></textarea> <br>
		파일: <input type="file" name="bfile"> <br>
		
		<input type="submit" value="발행"> <br>
	</form>
	
</body>
</html>