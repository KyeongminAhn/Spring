<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>welcome.jsp</h2>
	<!-- welcomemsg 라는 주소로 msg라는 파라미터에 데이터를 담아서 전송 -->
	<!-- 데이터를 보낼 땐 input태그 내 파라미터에 담아서 보내야~ name속성에 파라미터 지정해서-->
	<!-- form태그 전송방식: 주소창에 데이터 노출여부에 따라 get, post -->
	<form action="welcomemsg" method="get">
		입력메시지: <input type="text" name="msg"> <br>
		입력메시지2: <input type="text" name="msg2"> <br>
		<input type="submit" value="전송">	
	</form>
	
	<!-- 링크를 통해 파라미터 전송하기 -->
	<!-- 데이터 전송 시, 주소값을 참고. 보낸 주소값을 그대로 대입. -->
	<a href="linkmsg?val1=데이터1&val2=데이터2">
		링크로데이터전송</a>

</body>
</html>