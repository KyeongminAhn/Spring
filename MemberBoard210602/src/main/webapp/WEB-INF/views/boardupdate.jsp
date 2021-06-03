<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function update() {
			updateform.submit();
	}
</script>
</head>
<body>
	<h2>boardupdate.jsp</h2>
	<form action="bupdateprocess" method="post" name="updateform">
		글번호: <input type="text" name="bnumber" value="${boardUpdate.bnumber}" readonly> <br>
		제목: <input type="text" name="btitle" value="${boardUpdate.btitle}"> <br>
		작성자: <input type="text" name="bwriter" value="${boardUpdate.bwriter}" readonly> <br>
		내용: <textarea name="bcontents" rows="5" value="${boardUpdate.bcontents}"></textarea> <br>
	 	<input type="button" onclick="update()" value="수정"> 
	</form>
</body>
</html>