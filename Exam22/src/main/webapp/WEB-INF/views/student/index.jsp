<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
@font-face {
    font-family: 'NPSfontBold';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2310@1.0/NPSfontBold.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
}
</style>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body style="font-family: 'NPSfontBold';">
<%
	String context = request.getContextPath();
%>
<h2 style="text-align:center">학생 정보를 입력해주세요</h2>
<form style="text-align:center" action="StudentView" method="post">
	<p>이름 : <input type="text" name="name"/> </p>
	<p>나이 : <input type="text" name="age"/> </p> 
	<p>학년 : <input type="text" name="gradeNum"/> </p> 
	<p>반 : <input type="text" name="classNum"/> </p> 
	<input type="submit" value="전송"/>
</form>
</body>
</html>