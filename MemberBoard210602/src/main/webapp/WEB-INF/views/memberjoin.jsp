<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function idoverlap() {
		var inputId = document.getElementById('mid').value;
		var checkResult = document.getElementById('checkresult');
		$.ajax({
			type: 'post', // 전송방식
			url: 'idcheck', // 요청주소(컨트롤러에서 받는 주소)
			data: {'mid': inputId}, // 전송할 파라미터(데이터)
			dataType: 'text', // 리턴데이터형식(컨트롤러에서 다시 받아올 때)
			success: function(midcheck){ // 성공시 처리할 함수
				if(midcheck=="ok"){
					checkResult.style.color = 'green';
					checkResult.innerHTML = '사용가능한 아이디입니다.';
				} else {
					checkResult.style.color = 'red';
					checkResult.innerHTML = '이미 사용중인 아이디입니다.';
				}
			},
			error: function(){

			}
		});
		
		
	}
</script>	
</head>
<body>
	<h2>memberjoin.jsp</h2>
	<form action="memberjoin" method="post" enctype="multipart/form-data">
		아이디: <input type="text" name="mid" id="mid" onkeyup="idoverlap()">
					<span id="checkresult"></span><br>
		비밀번호: <input type="text" name="mpassword"><br>
		이름: <input type="text" name="mname"><br>
		전화번호: <input type="text" name="mphone"><br>
		이메일: <input type="text" name="memail"><br>
		프로필사진: <input type="file" name="mfile"> <br>
		
		<input type="submit" value="회원가입">
	</form>
</body>
</html>