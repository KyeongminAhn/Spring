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
	<div style="background-color:blue;">
	<form action="boardwrite" method="post">
		글제목: <input type="text" name="btitle"> <br>
		글비번: <input type="text" name="bpassword"> <br>
		작성자: <input type="text" name="bwriter"> <br>
		내용: <textarea name="bcontents" rows="5"></textarea> <br>
		<input type="submit" value="발행"> <br>
	</form>
	</div>
	
	<div style="background-color:skyblue;">
	<h2>파일 첨부용 글쓰기</h2>
		<form action="boardwritefile" method="post" enctype="multipart/form-data">
		글제목: <input type="text" name="btitle"> <br>
		글비번: <input type="text" name="bpassword"> <br>
		작성자: <input type="text" name="bwriter"> <br>
		내용: <textarea name="bcontents" rows="5"></textarea> <br>
		파일: <input type="file" name="bfile"> <br>
		
		<input type="submit" value="발행"> <br>
	</form>
	</div>
	
	
</body>
</html>