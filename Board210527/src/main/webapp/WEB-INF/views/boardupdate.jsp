<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function updatefn() {
		var passwordConfirm = document.getElementById('pwd').value;
		var password = '${board.bpassword}';
		if(password == passwordConfirm) {
			updateform.submit();
		} else {
			alert('비밀번호가 틀립니다!!');	
		}
	}
</script>
</head>
<body>
	<h2>boardupdate.jsp</h2>
	<!-- update form태그에 부적합한 열유형이 뜸. -->
	<form action="updateprocess" method="post" name="updateform">
		글번호: <input type="text" name="bnumber" value="${board.bnumber}" readonly> <br>
		제목: <input type="text" name="btitle" value="${board.btitle}"> <br>
		글비번: <input type="text" name="bpassword" id="pwd"> <br>
		작성자: <input type="text" name="bwriter" value="${board.bwriter}" readonly> <br>
		내용: <textarea name="bcontents" rows="5" value="${board.bcontents}"></textarea> <br>
		작성일자: <input type="text" name="bdate" value="${board.bdate}" readonly> <br>
		조회수: <input type="text" name="bhits" value="${board.bhits}" readonly> <br>
	</form>
</body>
</html>