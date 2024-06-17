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
<title>로그인 확인 페이지</title>
</head>
<body style="font-family: 'NPSfontBold';">
<div style="text-align:center">
	<h2>😇 로그인 결과</h2> <hr style="width:500px;"> <br>
	<p>이름: ${s.name}</p> 
	<p>아이디: ${s.id}</p>
</div>
</body>
</html>