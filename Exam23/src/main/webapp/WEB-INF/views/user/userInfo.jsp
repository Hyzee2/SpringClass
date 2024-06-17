<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
@font-face {
	font-family: 'NPSfontBold';
	src:
		url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2310@1.0/NPSfontBold.woff2')
		format('woff2');
	font-weight: 700;
	font-style: normal;
}
</style>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body style="font-family: 'NPSfontBold';">
	ID : ${u.id}
	<br> PW : ${u.pw}
	<br> 이메일 : ${u.mail}
	<br> 이름 : ${u.name}
	<br> 주민번호 : ${u.IDnum} 
	<br> 생일 : ${u.birth}
	<br> 취미 : ${u.hobby}
	<br> 자기소개 : ${u.introduction}
</body>
</html>