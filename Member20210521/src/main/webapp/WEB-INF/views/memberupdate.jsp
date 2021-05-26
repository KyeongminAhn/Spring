<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function updatefn() {
		// 사용자가 입력한 비밀번호와 DB에서 가져온 비밀번호 일치여부를 판단해서
		// 일치하면 form태그 전송, 일치하지 않으면 alert 출력
		// 사용자 입력값
		var passwordConfirm = document.getElementById('pwd').value; // 사용자가 입력한 비번
		var password = '${member123.mPassword}'; // DB에서 가져온 비번
		if(password == passwordConfirm) {
			updateform.submit();
		} else {
			alert('비밀번호가 틀립니다!!');	
		}
		
	}
</script>
</head>
<body>
	<h2>memberupdate.jsp</h2>
	<!-- 비밀번호 입력란은 비워놓고 비밀번호를 사용자로부터 입력받아 DB에 저장된 정보와 일치하면
			수정처리 진행, 일치하지 않으면 현재 페이지에 머무름. -->
	<form action="updateprocess" method="post"name="updateform">
		아이디: <input type="text" name="mId" value="${member123.mId}" readonly> <br>
		비밀번호: <input type="text" name="mPassword" id="pwd"> <br>
		이름: <input type="text" name="mName" value="${member123.mName}" readonly> <br>
		이메일: <input type="text" name="mEmail" value="${member123.mEmail}"> <br>
		
		<!-- js함수를 호출하고 싶을 때는 type을 button으로 하여 사용 -->
		<input type="button" value="수정" onclick="updatefn()">
		
		<!-- type을 submit 혹은 button태그를 클릭하면 form태그 내용이 무조건 전송됨. -->
		<input type="submit" value="submit버튼">
		<button>버튼버튼</button>
	</form>
</body>
</html>