<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<div class="flex justify-center flex-col text-center">
		<%@ include file="titleBar.jsp"%>
		<div class="flex justify-center">
			<table class="w-auto border border-gray-200 border-spacing-2">
				<tr class="bg-gray-100">
					<th class="px-8">번호</th>
					<th class="px-8">이름</th>
					<th class="px-32 py-2">제목</th>
					<th>날짜</th>
					<th class="px-8">히트</th>
				</tr>
				<c:forEach items="${list}" var="dto">
					<tr class="hover:bg-yellow-200">
						<td>${dto.bId}</td>
						<td>${dto.bName}</td>
						<td><c:forEach begin="1" end="${dto.bIndent}">└Re:</c:forEach>
							<a href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>

						<td><fmt:formatDate value="${dto.bDate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${dto.bHit}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" class="py-4">
						<button class="px-6 py-2 bg-yellow-200 hover:bg-slate-400 rounded">
							<a href="write_view">글작성</a>
						</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>