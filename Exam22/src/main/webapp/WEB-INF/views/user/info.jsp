<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입정보</title>
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
</head>
<body style="font-family: 'NPSfontBold';">
	ID : ${user.id}
	<br> PW : ${user.pw}
	<br> 이메일 : ${user.mail}
	<br> 이름 : ${user.name}
	<br> 주민번호 : ${user.IDnum}
	<br> 생일 :
	${user.birth}
	<br> 취미 :
	${user.hobby}
	<br> 자기소개 : ${user.introduction}
</body>
</html>