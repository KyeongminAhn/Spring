<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script>
	function emailSelect() {
    	var email = document.getElementById('emailCheck').value;
    	var domainValue = document.getElementById('domain');
    	domainValue.value = email;
	}
</script> -->
</head>
<body>
	<h2>memberJoin.jsp</h2>
	<form action="memberJoin" method="post">
		아이디: <input type="text" name="mid"> <br>
		비밀번호: <input type="text" name="mPassword"> <br>
		이름: <input type="text" name="mName"> <br>
		이메일: 
   	    <input type="text" name="mEmail">
<!--	@<input type="text" id="domain">
    	<select id="emailCheck" onchange="emailSelect()">
        	<option selected>직접입력</option>
        	<option value="naver.com">naver.com</option>
        	<option value="gmail.com">gmail.com</option>
        	<option value="hanmail.net">hanmail.net</option>
    	</select>--> <br>
    	<input type="submit" value="전송">
	</form>
</body>
</html>