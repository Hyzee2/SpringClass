<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
@font-face {
    font-family: 'NPSfontBold';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2310@1.0/NPSfontBold.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
}
</style>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body style="font-family: 'NPSfontBold';">
<div style="text-align:center;">
	<h2>😊 학생 로그인</h2> <hr style="width:500px;"> <br>
	<form action="login" method="post">
		<p>이 름: <input type="text" name="name" value="${student.name}"/></p>
		<p>아이디: <input type="text" name="id" value="${student.id}"/></p> <br>
		<input type="submit" value="전송" style="width:100px; height:30px; font-family: 'NPSfontBold';">
	</form>
</div>
</body>
</html>