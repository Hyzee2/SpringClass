<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="./adminNavBar.jsp"></c:import>
<title>회원 상세보기</title>
	<style>
       body {
           font-family: Arial, sans-serif;
           background-color: #f0f0f0;
           margin: 0;
           padding: 0;
       }
       .container {
           max-width: 900px;
           margin: 20px auto;
           padding: 20px;
           background-color: #fff;
           border-radius: 5px;
           box-shadow: 0 0 10px rgba(0,0,0,0.1);
       }
       h1 {
           color: #333;
           font-size: 24px; /* Adjusted from larger size for uniformity */
           margin-bottom: 20px;
           text-align: center;
       }
       h2 {
           color: #555;
           font-size: 16px; /* Smaller font size for table headers and cells */
           margin-bottom: 10px;
       }
       table {
           width: 100%;
           border-collapse: collapse;
           text-align: left;
       }
       th, td {
           padding: 8px;
           border: 1px solid #ccc; /* Subtle border color */
           text-align: left;
       }
       th {
           background-color: #f9f9f9; /* Lighter background for headers */
       }
   </style>
</head>
<body>
<br>
<br>
<h1>회원 상세 정보</h1>
    <div class="container">
         <c:set var="user" value="${userDetail}" />
         <table>
         	<tr>
         		<th>아이디</th>
         		<th>이름</th>
         		<th>주민등록번호</th>
         		<th>메일주소</th>
         		<th>생년월일</th>
         		<th>취미</th>
         		<th>소개글</th>
         	</tr>
         	<tr>
         		<td>${user.id}</td>
         		<td>${user.name}</td>
         		<td>${user.IDnum}</td>
         		<td>${user.mail}</td>
         		<td>${user.birth}</td>
         		<td>${user.hobby}</td>
         		<td>${user.introduction}</td>
         	</tr>
         </table>
        
    </div>
</body>
</html>