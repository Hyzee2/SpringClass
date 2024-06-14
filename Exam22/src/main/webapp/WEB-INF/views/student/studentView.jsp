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
<title>학생정보</title>
</head>
<body style="font-family: 'NPSfontBold';">
<h2 style="text-align:center">${student.name}의 정보</h2>
<div style="text-align:center;">
<img alt="student" src="../resources/Lion.png">
<p>이름 : ${student.name}</p>
<p>나이 : ${student.age} </p>
<p>학년 : ${student.gradeNum} </p>
<p>반 : ${student.classNum} </p>
</div>
</body>
</html>