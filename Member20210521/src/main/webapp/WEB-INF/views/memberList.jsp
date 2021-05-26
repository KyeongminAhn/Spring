<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function memberviewAjax(mId) {
		console.log(mId);
		/* 
			ajax를 이용하여 id를 컨트롤러로 보냄
			DB에서 해당 id의 정보를 리턴받고 리턴받은 값을 화면에 출력.
			json(javascript object notation): 데이터 형식(요즘 많이 사용됨.)
			-객체(object)형태로 거의 모든 데이터를 담아갈 수 있다.
			-콜론(:)형태로 되어 있어 가독성 ↑
		*/
		$.ajax({
			type: 'post', // 전송방식(get,post,delete,patch,put)
			url: 'memberviewajax', // 요청주소(컨트롤러에서 받는 주소)
			data: {'mId': mId}, // 전송할 파라미터:(데이터)
			dataType: 'json',
			success: function(result) {
				console.log(result);
				console.log(result.mId);
				console.log(result.mPassword);
				console.log(result.mName);
				console.log(result.mEmail);
				
				var output = "<table>";
				output += "<tr><th>ID</th> <th>PASSWORD</th> <th>NAME</th>";
				output += "<th>EMAIL</th> </tr>";
				output += "<tr>";
				output += "<td>"+result.mId+"</td>";
				output += "<td>"+result.mPassword+"</td>";
				output += "<td>"+result.mName+"</td>";
				output += "<td>"+result.mEmail+"</td>";
				output += "</tr>";
				output += "</table>";
				
				document.getElementById('memberviewdiv').innerHTML = output;
			},
			error: function() {
				console.log('문제발생');
			}
		});
	}
</script>
<style>
	table, tr, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h2>memberList.jsp</h2>
	
	로그인아이디: ${sessionScope.loginMember} <br>
	
	<div>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>상세조회</th>
			<th>삭제</th>
			<th>상세조회(ajax)</th>

		</tr>
		<c:forEach var="member" items="${mList}">
			<tr>
				<td>${member.mId}</td>
				<td>${member.mPassword}</td>
				<td>${member.mName}</td>
				<td>${member.mEmail}</td>
				<!-- 조회 링크를 클릭하면 memberview.jsp에 해당 회원의 정보만 출력 -->
				<!-- 여기선 id를 기준으로 잡아본다. -->
				<td><a href="memberview?mId=${member.mId}">조회</a></td>
				<!-- http://localhost:8081/member/memberview?mId=id1
						memberview 라는 주소 요청하면서 mId 파라미터에 id1을 담아서 간다 -->
				<td><button onclick="deletefn('${member.mId}')">삭제</button>
				<td><button onclick="memberviewAjax('${member.mId}')">조회(ajax)</button>
			</tr>	
		</c:forEach>
	</table>
	
	<!-- ajax로 가져온 상세조회 데이터를 아래 div에 출력 -->
	<div id="memberviewdiv"></div>
	
	<script>
	/* 삭제든 수정이든 기준 데이터는 PK컬럼인 id! */
		function deletefn(id) {
			console.log('삭제할 아이디' + id);
			location.href="memberdelete?mId="+id;
			// location.href="mbmberdelete?mId=id;(X)
		}
	</script>
	</div>
	
	<a href="./">홈으로</a>
</body>
</html>